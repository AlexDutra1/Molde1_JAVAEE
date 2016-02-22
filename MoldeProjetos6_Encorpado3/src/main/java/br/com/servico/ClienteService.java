package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.ClienteNegocios;

public class ClienteService {

	@Inject
	private ClienteNegocios negocios;
	
	@Inject
	private EstadoService estadoService;
	
	@Inject
	private MunicipioService municipioService;
	
	@Inject
	private TelefoneService telefoneService;
	
	@Inject
	private InteresseService interesseService;
	
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

	public MunicipioService getMunicipioService() {
		return municipioService;
	}

	public void setMunicipioService(MunicipioService municipioService) {
		this.municipioService = municipioService;
	}

	public TelefoneService getTelefoneService() {
		return telefoneService;
	}

	public void setTelefoneService(TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}

	public InteresseService getInteresseService() {
		return interesseService;
	}

	public void setInteresseService(InteresseService interesseService) {
		this.interesseService = interesseService;
	}
	
}
