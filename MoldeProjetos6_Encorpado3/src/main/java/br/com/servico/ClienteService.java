package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.ClienteNegocios;

public class ClienteService {

	@Inject
	private ClienteNegocios negocios;
	
	@Inject
	private EstadoService estadoService;
	

	public ClienteNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(ClienteNegocios negocios) {
		this.negocios = negocios;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
}
