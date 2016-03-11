package br.com.persistencia.implementacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.modelo.Cliente;
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
