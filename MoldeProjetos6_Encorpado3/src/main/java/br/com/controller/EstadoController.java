package br.com.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.EstadoFormulario;
import br.com.modelo.Estado;
import br.com.servico.EstadoService;


@ApplicationScoped
@Named("estadoController")
public class EstadoController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EstadoService service;
	
	@Inject
	private EstadoFormulario formulario;

	public String acaoAposCadastrar(){
		
		//Salva estado
		this.service.getNegocios().getDao().guardar(this.getFormulario().getEstado());
		
		this.formulario.setEstado(new Estado());
		
		return null;
	}

	public EstadoFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(EstadoFormulario formulario) {
		this.formulario = formulario;
	}

	public EstadoService getService() {
		return service;
	}

	public void setService(EstadoService service) {
		this.service = service;
	}
	
}
