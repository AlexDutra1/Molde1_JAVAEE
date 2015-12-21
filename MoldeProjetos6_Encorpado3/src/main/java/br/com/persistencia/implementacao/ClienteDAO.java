package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.modelo.Cliente;
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
	
	public List<Cliente> consultarPorNomeDAO(String nome) {
		
		Query consulta=manager.createQuery("select a from Cliente a where nome='"+nome+"'",Cliente.class);
				
		return consulta.getResultList();
	}


	//CONSULTA POR ID
	public Cliente consultaPorId(int idCliente){
		
		Cliente cliente=manager.find(Cliente.class, idCliente);
		
		return cliente;
	}

	
	
	
	
	
}
