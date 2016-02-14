package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.EnderecoNegocios;

public class EnderecoService {

	@Inject
	private EnderecoNegocios negocios;
	
	@Inject
	private EstadoService estadoService;

	public EnderecoNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(EnderecoNegocios negocios) {
		this.negocios = negocios;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
}
