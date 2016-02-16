package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.MunicipioNegocios;

public class MunicipioService {

	@Inject
	private MunicipioNegocios negocios;

	public MunicipioNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(MunicipioNegocios negocios) {
		this.negocios = negocios;
	}
}
