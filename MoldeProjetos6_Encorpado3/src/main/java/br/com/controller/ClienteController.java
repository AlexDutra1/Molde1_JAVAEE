package br.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.controller.formulario.ClienteFormulario;
import br.com.modelo.Cliente;
import br.com.modelo.Interesse;
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
		listaTelefones.add(this.getFormulario().getTelefone());
		
		//Configura os telefones no cliente
		this.formulario.getCliente().setTelefone(listaTelefones);
		
		//Configura os interesses no cliente
		//this.formulario.getCliente().setInteresses(this.getFormulario().getListaInteresses());
		
		
		
		//Salva no banco de dados
		this.service.getNegocios().getDao().guardar(this.getFormulario().getCliente());
		
		//Limpa o formulario
		this.formulario=null;
		RequestContext.getCurrentInstance().update(Arrays.asList("formCadastroCliente"));
		
		
	}
	
	public void adicionaTelefone(){
		
		List <Telefone> lista=new ArrayList<Telefone>();
		lista.add(this.formulario.getTelefone());
		this.formulario.setListaTelefones(lista);
		
		RequestContext.getCurrentInstance().update(Arrays.asList("formCadastroCliente:tabelaTelefones"));
		
		System.out.println("TELEFONE ADICIONADO");
	}
	
	public void adicionaInteresse(){
	
		//this.formulario.getListaInteresses().add(this.formulario.getInteresse());

 		List <Interesse> listaB=new ArrayList<Interesse>();
		listaB.add(this.formulario.getInteresse());
		this.formulario.setListaInteresses(listaB);
		
		RequestContext.getCurrentInstance().update(Arrays.asList("formCadastroCliente:tabelaInteresses"));
		
		System.out.println("INTERESSE ADICIONADO");
		
	}
	
	public String abreCadastro(){
		
		return "cadastroCliente";
	}
	
	public void excluirRegistro(Cliente clienteExcluir){
		
		this.service.getNegocios().getDao().excluir(clienteExcluir);
	
	}
	
	
	public String preparaEdicao(Cliente clienteEditar){
		
		this.formulario.setCliente(clienteEditar);

		return "editarCliente.xhtml";
	}
		
	public void pesquisar(){
		
		//Faz consulta pelo nome
		this.formulario.setTodosClientes(this.service.getNegocios().getDao().consultarPorNomeDAO(this.formulario.getCliente().getNome()));
		
	}
	
	public String visualizaTelefones(Cliente cliente){
		
		return "visualizaTelefones.xhtml";
	}
	
	public String visualizaInteresses(Cliente cliente){
		
		this.formulario.setCliente(cliente);
		
		return "visualizaInteresses.xhtml";
	}

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
