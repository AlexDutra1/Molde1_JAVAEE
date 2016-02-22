package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.InteresseNegocios;

public class InteresseService {

	@Inject
	private InteresseNegocios negocios;

	public InteresseNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(InteresseNegocios negocios) {
		this.negocios = negocios;
	}
}
