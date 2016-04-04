package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.MunicipioNegocios;

public class MunicipioService {

	@Inject
	private MunicipioNegocios negocios;
	
	@Inject
	private EstadoService estadoService;

	public MunicipioNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(MunicipioNegocios negocios) {
		this.negocios = negocios;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
}
