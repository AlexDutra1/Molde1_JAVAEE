package br.com.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.EnderecoFormulario;
import br.com.modelo.Estado;
import br.com.servico.EnderecoService;

@Named("enderecoController")
@ApplicationScoped
public class EnderecoController  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EnderecoService service;
	
	@Inject
	private EnderecoFormulario formulario;
	
	@Inject
	private Estado estadoTeste;
	
	@PostConstruct
	public void init(){
		
		this.getFormulario().setTodosEstados(this.getService().getEstadoService().getNegocios().getDao().todosEstadosCombo());
	}
	
	public void acaoAposCadastrar(){
		
		System.out.println("Clicado");
		
		
		//TESTE
		/*
		estadoTeste.setNome("Estado teste 1");
		this.formulario.getEndereco().setEstado(estadoTeste);
		*/
		
		System.out.println("VALOR: "+this.formulario.getEstadoSelecionado());
		
		//FORMA CORRETA ABAIXO
		//Configura Estado ao Endereço
		this.formulario.getEndereco().setEstado(this.formulario.getEstadoSelecionado());
		
		
		//Salva no banco de dados
		this.service.getNegocios().getDao().guardar(this.formulario.getEndereco());
		//this.service.getNegocios().getDao().guardar(this.getFormulario().getEndereco());
	}

	public EnderecoService getService() {
		return service;
	}

	public void setService(EnderecoService service) {
		this.service = service;
	}

	public EnderecoFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(EnderecoFormulario formulario) {
		this.formulario = formulario;
	}

	public Estado getEstadoTeste() {
		return estadoTeste;
	}

	public void setEstadoTeste(Estado estadoTeste) {
		this.estadoTeste = estadoTeste;
	}

}
