package br.com.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.MunicipioFormulario;
import br.com.servico.MunicipioService;


@Named("municipioController")
@ApplicationScoped
public class MunicipioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MunicipioService service;
	
	@Inject
	private MunicipioFormulario formulario;

	public void acaoAposCadastrar(){
		
		System.out.println("Clicado");
		System.out.println("NOME MUNICIPIO"+this.formulario.getMunicipio().getNome());
		System.out.println("MUNICIPIO: "+this.formulario.getMunicipio());
		System.out.println("ESTADO: "+this.formulario.getEstadoSelecionado());
		System.out.println("ESTADO SIGLA: "+this.formulario.getEstadoSelecionado().getSigla());
		
		//Associa municipio ao estado
		this.formulario.getMunicipio().setEstado(this.formulario.getEstadoSelecionado());
		
		//Salva no banco de dados o municipio associado ao estado
		this.service.getNegocios().getDao().guardar(this.getFormulario().getMunicipio());
	}
	
	@PostConstruct
	public void init(){
		
		//this.getFormulario().setTodosEstados(this.getService().getEstadoService().getNegocios().getDao().todosEstadosCombo());
	}
	
	
	public MunicipioService getService() {
		return service;
	}

	public void setService(MunicipioService service) {
		this.service = service;
	}

	public MunicipioFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(MunicipioFormulario formulario) {
		this.formulario = formulario;
	}



}