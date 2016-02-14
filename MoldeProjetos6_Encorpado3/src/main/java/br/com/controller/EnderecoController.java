package br.com.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.EnderecoFormulario;
import br.com.servico.EnderecoService;

@Named("enderecoController")
@ApplicationScoped
public class EnderecoController  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EnderecoService service;
	
	@Inject
	private EnderecoFormulario formulario;
	
	@PostConstruct
	public void init(){
		
		this.getFormulario().setTodosEstados(this.getService().getEstadoService().getNegocios().getDao().todosEstadosCombo());
	}
	
	public void acaoAposCadastrar(){
		
		System.out.println("Clicado");
		
		//Configura Estado ao Endereço
		//this.formulario.getCliente().getEndereco().setEstado(this.formulario.getEstadoSelecionado());
		
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

}
