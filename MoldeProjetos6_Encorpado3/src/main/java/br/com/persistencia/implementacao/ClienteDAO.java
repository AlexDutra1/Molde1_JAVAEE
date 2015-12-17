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

		System.out.println("ID: "+cliente.getIdCliente());
		System.out.println("Nome: "+cliente.getNome());
		System.out.println("Data de Nascimento: "+cliente.getDataNascimento());
		System.out.println("Email: "+cliente.getEmail());
		System.out.println("Genero: "+cliente.getGenero());
		
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		cliente=this.manager.merge(cliente);
		this.manager.merge(cliente);
		
		trx.commit();
		
	}
	
	/*//EXCLUI CLIENTE
	public void excluir(Cliente cliente) {
		
		tx.begin();
		
		cliente=em.merge(cliente);
		em.remove(cliente);
		
		tx.commit();
		em.close();
		
	}
*/	
	//CONSULTA TODOS OS CLIENTES
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarTodosDAO() {
		
		Query consulta=manager.createQuery("select a from Cliente a",Cliente.class);
				
		return consulta.getResultList();
	}


	//CONSULTA POR ID
	public Cliente consultaPorId(int idCliente){
		
		Cliente cliente=manager.find(Cliente.class, idCliente);
		
		return cliente;
	}

	
	
	
	
	
}
