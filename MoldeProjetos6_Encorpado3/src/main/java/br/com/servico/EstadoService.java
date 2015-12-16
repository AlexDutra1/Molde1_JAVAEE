package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.EstadoNegocios;

public class EstadoService {

	@Inject
	private EstadoNegocios negocios;

	public EstadoNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(EstadoNegocios negocios) {
		this.negocios = negocios;
	}
	
}
