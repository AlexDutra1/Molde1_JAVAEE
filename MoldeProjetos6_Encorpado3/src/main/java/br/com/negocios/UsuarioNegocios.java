package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.UsuarioDAO;

public class UsuarioNegocios {

	@Inject
	private UsuarioDAO dao;

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

}
