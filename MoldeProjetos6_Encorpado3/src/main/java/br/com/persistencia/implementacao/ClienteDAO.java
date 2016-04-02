package br.com.persistencia.implementacao;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Municipio;
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
	
	public List<Cliente> consultaPorCriterios(Cliente cliente , EnumGenero genero, Telefone telefone, Endereco endereco, Estado estado, Municipio municipio) {
		
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
		
		//RELACIONAMENTO TELEFONE
	
		//CONSULTA POR NUMERO
		if(!telefone.getNumero() .equals("")){
			Path<String> atributoTelefoneNumero = root.join("telefone").get("numero");
			Predicate whereTelefone = criteriaBuilder.equal(atributoTelefoneNumero, telefone.getNumero());
			condicoes.add(whereTelefone);
		}
		
		//RELACIONAMENTO ENDEREÇO
		
		//CONSULTA POR LAGRADOURO
		if(!endereco.getLagradouro() .equals("")){
			Path<String> atributoEnderecoLagradouro = root.join("endereco").get("lagradouro");
			Predicate whereEndereco = criteriaBuilder.equal(atributoEnderecoLagradouro, endereco.getLagradouro());
			condicoes.add(whereEndereco);
		}
		
		//SITUAÇÃO
		/*OU CONSULTA DE ESTADO FUNCIONA OU CONSULTA DE MUNICIPIO
		 * NÂO PODE HAVER REFERENCIAS AO MESMO TEMPO DAS DUAS ENTIDADES
		 * ARRANJAR OUTRA FORMA DE CONSULTAR
		 * PROCURA SOBRE METAL MODEL
		 * NOMES COM ACENTO NÃO SÂO ACEITOS
		 * BACKUP ABAIXO
		 */
		
		//CONSULTA POR ESTADO
		if(estado != null){
			Path<String> atributoEstadoNome = root.join("endereco").get("estado").get("nome");
			Predicate whereEstado = criteriaBuilder.like(atributoEstadoNome, estado.getNome());
			condicoes.add(whereEstado);
		}
		
		//CONSULTA POR MUNICIPIO
		if(municipio!= null){
			Path<String> atributoMunicipioNome = root.join("endereco").join("municipio").get("nome");
			System.out.println("NA OPERACAO: "+municipio.getNome());
			System.out.println("NA OPERACAO-ALIAS: "+atributoMunicipioNome);
			Predicate whereMunicipio = criteriaBuilder.like(atributoMunicipioNome, municipio.getNome());
			condicoes.add(whereMunicipio);
		}
		
		//FINAL
		
		Predicate[] condicoesComoArray =
		condicoes.toArray(new Predicate[condicoes.size()]);
		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);
		criteriaQuery.where(todasCondicoes);

		TypedQuery<Cliente> query =this.manager.createQuery(criteriaQuery);
		
		List <Cliente> list=query.getResultList();
		
		for (Cliente cliente2 : list) {
			System.out.println("LISTA ANTES DO RETORNO-CLIENTES: "+cliente2.getNome());
		}
		
		return list;
	}

	@SuppressWarnings("unchecked")
	public List <Cliente> consultaClientePorMunicipio(Municipio municipio){
			
			Query consulta=manager.createQuery("SELECT a FROM Cliente a JOIN a.endereco e JOIN e.municipio o ON o.nome LIKE'"+municipio.getNome()+"'", Cliente.class);
			
			return consulta.getResultList();
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
