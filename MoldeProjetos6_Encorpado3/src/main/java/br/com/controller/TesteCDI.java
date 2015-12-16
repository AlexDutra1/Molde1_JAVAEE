package br.com.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Cliente;

@RequestScoped
@Named
public class TesteCDI {

	private String chegou;

	@Inject
	private Cliente cliente;
	
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
	
}
