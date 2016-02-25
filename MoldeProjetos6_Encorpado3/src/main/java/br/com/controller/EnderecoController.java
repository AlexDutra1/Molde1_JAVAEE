package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.AjaxBehaviorEvent;
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
	
	@PostConstruct
	public void init(){
		
		this.getFormulario().setTodosEstados(this.getService().getEstadoService().getNegocios().getDao().todosEstadosCombo());
		
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
	
	public void atualizaComboMunicipio(AjaxBehaviorEvent event){
		
		this.formulario.setTodosMunicipios(this.service.getMunicipioService()
				.getNegocios().getDao()
				.consultaMunicipiosPeloEstado(this.formulario.getEstadoSelecionado()));
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
