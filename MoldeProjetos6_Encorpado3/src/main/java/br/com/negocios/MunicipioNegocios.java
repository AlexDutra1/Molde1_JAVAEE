package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.MunicipioDAO;

public class MunicipioNegocios {

	@Inject
	private MunicipioDAO dao;

	public MunicipioDAO getDao() {
		return dao;
	}

	public void setDao(MunicipioDAO dao) {
		this.dao = dao;
	}
}
