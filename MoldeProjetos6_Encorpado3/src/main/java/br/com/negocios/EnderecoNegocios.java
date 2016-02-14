package br.com.negocios;

import javax.inject.Inject;

import br.com.persistencia.implementacao.EnderecoDAO;

public class EnderecoNegocios {

	@Inject
	private EnderecoDAO dao;

	public EnderecoDAO getDao() {
		return dao;
	}

	public void setDao(EnderecoDAO dao) {
		this.dao = dao;
	}
}
