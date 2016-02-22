package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.InteresseDAO;

public class InteresseNegocios {

	@Inject
	private InteresseDAO dao;

	public InteresseDAO getDao() {
		return dao;
	}

	public void setDao(InteresseDAO dao) {
		this.dao = dao;
	}
}
