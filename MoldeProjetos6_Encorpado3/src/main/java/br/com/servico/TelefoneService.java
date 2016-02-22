package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.TelefoneNegocios;

public class TelefoneService {

	@Inject
	private TelefoneNegocios negocios;

	public TelefoneNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(TelefoneNegocios negocios) {
		this.negocios = negocios;
	}
}
