package br.com.persistencia.implementacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.modelo.Municipio;
import br.com.persistencia.interfaces.MunicipioGerenciable;

public class MunicipioDAO implements MunicipioGerenciable {

private EntityManager manager;
	
	@Inject
	public MunicipioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/* 
	 * Permite fazer o CREATE e UPDATE
	 */
	public void guardar(Municipio municipio) {

		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		municipio=this.manager.merge(municipio);
		this.manager.merge(municipio);
		
		trx.commit();
		
	}

}
