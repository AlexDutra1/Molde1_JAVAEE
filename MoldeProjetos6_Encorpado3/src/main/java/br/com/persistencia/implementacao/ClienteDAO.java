package br.com.persistencia.implementacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.modelo.Cliente;
import br.com.modelo.Telefone;
import br.com.modelo.enums.EnumGenero;
import br.com.persistencia.interfaces.ClienteGerenciable;

public class ClienteDAO implements ClienteGerenciable {

	private EntityManager manager;
	
	@Inject
	public ClienteDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/* 
	 * Permite fazer o CREATE e UPDATE
	 */
	@Override
	public void guardar(Cliente cliente) {

		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		cliente=this.manager.merge(cliente);
		this.manager.merge(cliente);
		
		trx.commit();
		
	}
	
	//EXCLUI CLIENTE
	public void excluir(Cliente cliente) {
		
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		cliente=manager.merge(cliente);
		manager.remove(cliente);
		
		trx.commit();
		
	}

	//CONSULTA TODOS OS CLIENTES
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarTodosDAO() {
		
		Query consulta=manager.createQuery("select a from Cliente a",Cliente.class);
				
		return consulta.getResultList();
	}
	
	public List<Cliente> consultaPorCriterios(Cliente cliente , EnumGenero genero, Telefone telefone) throws NullPointerException {
		
		//CRITERIA JPA
		
		CriteriaBuilder criteriaBuilder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery =
		criteriaBuilder.createQuery(Cliente.class);
		
		//root é a raiz da consulta
		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		
		List<Predicate> condicoes = new ArrayList<Predicate>();
		
		//NOME
		if(!cliente.getNome().equals("")){
		Path<String> atributoNome = root.get("nome");
		Predicate whereNome = criteriaBuilder.like(atributoNome, cliente.getNome());
		condicoes.add(whereNome);
		}
		
		//EMAIL
		if(!cliente.getEmail() .equals("")){
		Path<String> atributoEmail = root.get("email");
		Predicate whereEmail = criteriaBuilder.like(atributoEmail, cliente.getEmail());
		condicoes.add(whereEmail);
		}
		
		//RENDA MENSAl
		if(cliente.getRendaMensal() != null){
		Path<BigDecimal> atributoRendaMensal = root.get("rendaMensal");
		Predicate whereRendaMensal = criteriaBuilder.equal(atributoRendaMensal, cliente.getRendaMensal());
		condicoes.add(whereRendaMensal);
		}
		
		//GENERO
		if(genero != null){
		Path<String> atributoGenero = root.get("genero");
		Predicate whereGenero = criteriaBuilder.equal(atributoGenero, genero);
		condicoes.add(whereGenero);
		}
		
		//DATA DE NASCIMENTO
		if(cliente.getDataNascimento() != null){
		Path<Date> atributoDataNascimento = root.get("dataNascimento");
		Predicate whereDataNascimento = criteriaBuilder.equal(atributoDataNascimento, cliente.getDataNascimento());
		condicoes.add(whereDataNascimento);
		}
		
		/////////////////////////
		//RELACIONAMENTO TELEFONE
		
		//TELEFONE NUMERO
		/*
		if(telefone != null){
		Path<Telefone> atributoTelefone = rootTelefone.get("telefone");
		Predicate whereTelefone = criteriaBuilder.equal(atributoTelefone, telefone);
		condicoes.add(whereTelefone);
		}
		*/
		
		CriteriaBuilder criteriaBuilderTelefone = this.manager.getCriteriaBuilder();
		CriteriaQuery<Telefone> criteriaQueryTelefone =
		criteriaBuilderTelefone.createQuery(Telefone.class);
		
		Root<Telefone> rootTelefone = criteriaQueryTelefone.from(Telefone.class);
		
		//ORIGINAL
		//TypedQuery<Telefone> queryTelefone =this.manager.createQuery(criteriaQueryTelefone);
		/*
		TypedQuery<Telefone> typedQuery = this.manager.createQuery(
				criteriaQueryTelefone.select(rootTelefone )
			    .where(
			    	criteriaBuilderTelefone.equal(rootTelefone.join("Cliente").get("telefone"), telefone.getNumero())
			    )
			);
			List<Telefone> results = typedQuery.getResultList();
		
		for (Telefone telefone2 : results) {
			System.out.println("NUMEROS: "+telefone2.getNumero());
		}
		
		*/
		//List <Telefone> list=queryTelefone.getResultList();
/*
		Exemplo com varias entidades
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> from = query.from(Product.class);
		
		TypedQuery<Product> typedQuery = entityManager.createQuery(
		    query.select(from )
		    .where(
		       builder.equal(from.join("supplier").get("name"), supplierName)
		    )
		);
		List<Product> results = typedQuery.getResultList();
*/		
		

		
		
		
		
		
		
		//FINAL
		
		Predicate[] condicoesComoArray =
		condicoes.toArray(new Predicate[condicoes.size()]);
		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);
		criteriaQuery.where(todasCondicoes);

		TypedQuery<Cliente> query =this.manager.createQuery(criteriaQuery);
		
		List <Cliente> list=query.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> consultarPorNomeDAO(String nome) {
		
		Query consulta=manager.createQuery("select a from Cliente a where nome='"+nome+"'",Cliente.class);
				
		return consulta.getResultList();
	}

	//CONSULTA POR ID
	public Cliente consultaPorId(int idCliente){
		
		Cliente cliente=manager.find(Cliente.class, idCliente);
		
		return cliente;
	}

	//CONSULTA POR EMAIL
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorEmail(String email){
		
		Query consulta=manager.createQuery("select a from Cliente a where email='"+email+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	
	//CONSULTA POR DATA DE NASCIMENTO
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorDataNascimento(Date dataNascimento){
		
		Query consulta=manager.createQuery("select a from Cliente a where data_nascimento='"+dataNascimento+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	
	//CONSULTA POR DATA DE NASCIMENTO
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorGenero(EnumGenero genero){
		
		Query consulta=manager.createQuery("select a from Cliente a where genero='"+genero+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	
	//CONSULTA POR RENDA MENSAL
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorRendaMensal(BigDecimal rendaMensal){
		
		Query consulta=manager.createQuery("select a from Cliente a where renda='"+rendaMensal+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	
	//CONSULTA PELA LAGRADOURO-ENDERECO
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPeloLagradouro (String lagradouro){
		
		//BACKUP
		//Query consulta=manager.createQuery("SELECT a FROM Cliente a JOIN a.Endereco u ON u.lagradouro='"+lagradouro+"'", Cliente.class);
		
		Query consulta=manager.createQuery("SELECT a FROM Cliente a where a.endereco.lagradouro='"+lagradouro+"'", Cliente.class);
											//select p from Pessoa p where p.carro.cor = 'Vermelha'									
		//select p from Pessoa p join p.namoradas ex where ex.nome = 'Josefina Antonieta'
		//SELECT a FROM Interesse a JOIN a.clientes u ON u.idCliente='"+id+"'",Interesse.class);
		
		
		return consulta.getResultList();
	}
	
	/*
	//CONSULTA POR TELEFONE
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorTelefone(BigDecimal rendaMensal){
		
		Query consulta=manager.createQuery("select a from Cliente a where renda='"+rendaMensal+"'", Cliente.class);
		
		return consulta.getResultList();
	}
		
	//CONSULTA POR ENDEREÇO
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorEndereco (Endereco endereco){
		
		Query consulta=manager.createQuery("select a from Cliente a where renda='"+endereco.getLagradouro()+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	
	//CONSULTA POR INTERESSE
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaPorInteresses (Interesse interesse){
		
		Query consulta=manager.createQuery("select a from Cliente a where renda='"+interesse.getNome()+"'", Cliente.class);
		
		return consulta.getResultList();
	}
	*/
	
	
	
}
