package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.TelefoneDAO;

public class TelefoneNegocios {

	@Inject
	private TelefoneDAO dao;

	public TelefoneDAO getDao() {
		return dao;
	}

	public void setDao(TelefoneDAO dao) {
		this.dao = dao;
	}
}
