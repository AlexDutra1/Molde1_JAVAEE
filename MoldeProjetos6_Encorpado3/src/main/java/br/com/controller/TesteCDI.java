package br.com.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Cliente;
import br.com.modelo.Endereco;
import br.com.persistencia.implementacao.ClienteDAO;

@RequestScoped
@Named
public class TesteCDI {

	private String chegou;

	@Inject
	private Cliente cliente;
	
	@Inject
	private Endereco endereco;
	
	@Inject 
	private ClienteDAO dao;
	
	public void salvarCadastro(){
		
		//this.getService().getNegocios().getDao().guardar(this.getFormulario().getCliente());
		
		cliente.setEndereco(endereco);
		dao.guardar(cliente);
	}
	
	public void exibirMensagemNoConsole(){
		System.out.println("Mensagem: "+this.getCliente().getNome());
	}
	
	
	
	public String getChegou() {
		return chegou;
	}

	public void setChegou(String chegou) {
		this.chegou = chegou;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
