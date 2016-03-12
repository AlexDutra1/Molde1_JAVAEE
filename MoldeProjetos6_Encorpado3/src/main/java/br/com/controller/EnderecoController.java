package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

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
		this.getFormulario().setTodosEnderecos(this.service.getNegocios().getDao().consultarTodosClientesDAO());
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
	
	public void atualizaComboMunicipio(AjaxBehaviorEvent event){
		
		this.formulario.setTodosMunicipios(this.service.getMunicipioService()
				.getNegocios().getDao()
				.consultaMunicipiosPeloEstado(this.formulario.getEstadoSelecionado()));
	}
	
	public void pesquisar(){
		
		
		this.formulario.setTodosEnderecos(this.service
				.getNegocios().getDao()
				.pesquisaComCriterios(
						this.formulario.getEndereco(),
						this.formulario.getEstadoSelecionado(),
						this.formulario.getMunicipioSelecionado()));
		
		//ATUALIZA TABELA E CAMPO DE PESQUISA
		RequestContext.getCurrentInstance().update(Arrays.asList("formPesquisaEndereco:tabelaEnderecos"));
		
		/*
		//Limpa campos apos cadastro
		this.formulario.getUsuario().setNome("");
		this.formulario.getUsuario().setEmail("");
		this.formulario.getUsuario().setUsuario("");
		
		//ATUALIZA CAMPOS
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_nome");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_usuario");
		RequestContext.getCurrentInstance().update("formPesquisaUsuario:input_email");
	*/
		
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
