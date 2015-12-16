package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.EstadoDAO;

public class EstadoNegocios {

	@Inject
	private EstadoDAO dao;

	public EstadoDAO getDao() {
		return dao;
	}

	public void setDao(EstadoDAO dao) {
		this.dao = dao;
	}


	
}
