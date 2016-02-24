package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.EnderecoFormulario;
import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Municipio;
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
		this.getFormulario().setTodosMunicipios(this.getService().getMunicipioService().getNegocios().getDao().consultaTodosMunicipios());
		
	}
	
	public void acaoAposCadastrar(){
		
		//Configura Estado ao Endereço
		this.formulario.getEndereco().setEstado(this.formulario.getEstadoSelecionado());
		
		//Configura Municipio ao Endereco
		this.formulario.getEndereco().setMunicipio(this.formulario.getMunicipioSelecionado());
		
		//Salva no banco de dados
		this.service.getNegocios().getDao().guardar(this.formulario.getEndereco());
		
		//limpa os campos do endereco
		this.formulario.setEndereco(new Endereco());
		this.formulario.setTodosEstados(new ArrayList<Estado>());
		this.formulario.setTodosMunicipios(new ArrayList<Municipio>());
		
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
