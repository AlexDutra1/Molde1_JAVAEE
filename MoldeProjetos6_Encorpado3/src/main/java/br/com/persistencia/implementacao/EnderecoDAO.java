package br.com.persistencia.implementacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.modelo.Endereco;
import br.com.persistencia.interfaces.EnderecoGerenciable;

public class EnderecoDAO implements EnderecoGerenciable {

private EntityManager manager;
	
	@Inject
	public EnderecoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/* 
	 * Permite fazer o CREATE e UPDATE
	 */
	@Override
	public void guardar(Endereco endereco) {

		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		endereco=this.manager.merge(endereco);
		this.manager.merge(endereco);
		
		trx.commit();
		
	}

}
