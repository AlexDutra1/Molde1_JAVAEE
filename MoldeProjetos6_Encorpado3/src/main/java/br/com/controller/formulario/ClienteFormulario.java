package br.com.controller.formulario;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Cliente;
import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Interesse;




@ApplicationScoped
@Named("clienteFormulario")
public class ClienteFormulario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Cliente cliente;
	
	@Inject
	private Endereco endereco;
	
	private List <Cliente> todosClientes;

	private List <Estado> todosEstados;
	
	private List <Interesse> listaInteresses;
	
	private Long idEstadoSelecionado;
	
	
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Estado> getTodosEstados() {
		return todosEstados;
	}

	public void setTodosEstados(List<Estado> todosEstados) {
		this.todosEstados = todosEstados;
	}

	public Long getIdEstadoSelecionado() {
		return idEstadoSelecionado;
	}

	public void setIdEstadoSelecionado(Long idEstadoSelecionado) {
		this.idEstadoSelecionado = idEstadoSelecionado;
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public void setTodosClientes(List<Cliente> todosClientes) {
		this.todosClientes = todosClientes;
	}

	public List<Interesse> getListaInteresses() {
		return listaInteresses;
	}

	public void setListaInteresses(List<Interesse> listaInteresses) {
		this.listaInteresses = listaInteresses;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}





	



	









	
}
