package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.ClienteFormulario;
import br.com.modelo.Cliente;
import br.com.modelo.Telefone;
import br.com.servico.ClienteService;


@Named("clienteController")
@ApplicationScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService service;
	
	@Inject
	private ClienteFormulario formulario;
	
	
	public void acaoAposCadastrar(){
		
		//Configura endereco do usuario
		this.formulario.getCliente().setEndereco(formulario.getEndereco());
		
		//Pega o telefone fixo e o celular e insere em um array
		List <Telefone> listaTelefones=new ArrayList();
		listaTelefones.add(this.getFormulario().getTelefoneCelular());
		listaTelefones.add(this.getFormulario().getTelefoneFixo());
		
		//Configura os telefones no usuario
		this.formulario.getCliente().setTelefoneCelular(listaTelefones);
		
		//Salva no banco de dados
		this.service.getNegocios().getDao().guardar(this.getFormulario().getCliente());
		
		//Limpa os campos
		
	}
	
	public void excluirRegistro(Cliente clienteExcluir){
		
		this.service.getNegocios().getDao().excluir(clienteExcluir);
	
	}
	
	
	public String preparaEdicao(Cliente clienteEditar){
		
		this.formulario.setCliente(clienteEditar);

		return "editarCliente.xhtml";
	}
	/*
	public void salvarEdicao(){
		
				//Salva no banco de dados
				this.service.getNegocios().getDao().guardar(this.getFormulario().getCliente());
	}
	*/

	@PostConstruct
	public void init(){
		
		this.getFormulario().setTodosEstados(this.getService().getEstadoService().getNegocios().getDao().todosEstadosCombo());
		this.getFormulario().setTodosClientes(this.getService().getNegocios().getDao().consultarTodosDAO());
	}


	public String abrePesquisa(){
		
		return "pesquisaCliente";
	}




	public ClienteService getService() {
		return service;
	}




	public void setService(ClienteService service) {
		this.service = service;
	}




	public ClienteFormulario getFormulario() {
		return formulario;
	}




	public void setFormulario(ClienteFormulario formulario) {
		this.formulario = formulario;
	}




}
