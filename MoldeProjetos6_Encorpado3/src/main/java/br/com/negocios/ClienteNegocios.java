package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.ClienteDAO;

public class ClienteNegocios {

	@Inject
	private ClienteDAO dao;
	
	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}
	
	
}
