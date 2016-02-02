package br.com.controller.formulario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Cliente;
import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Interesse;
import br.com.modelo.Telefone;
import br.com.modelo.enums.EnumPreferencias;




@ApplicationScoped
@Named("clienteFormulario")
public class ClienteFormulario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Cliente cliente;
	
	@Inject
	private Endereco endereco;
	
	@Inject
	private Telefone telefone;
	
	@Inject
	private Telefone telefoneCelular;
	
	@Inject
	private Interesse interesse;
	
	private List <Cliente> todosClientes;

	private List <Estado> todosEstados;
	
	private List <Interesse> listaInteresses= new ArrayList<Interesse>();
	
	private List <String> listaPreferencias;
	
	private List <Telefone> listaTelefones;
	
	private Long idEstadoSelecionado;
	
	private EnumPreferencias enumPreferencias;
	
	
	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}
	
	public List<Telefone> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<Telefone> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

	public EnumPreferencias getEnumPreferencias() {
		return enumPreferencias;
	}

	public void setEnumPreferencias(EnumPreferencias enumPreferencias) {
		this.enumPreferencias = enumPreferencias;
	}

	public List<String> getListaPreferencias() {
		return listaPreferencias;
	}

	public void setListaPreferencias(List<String> listaPreferencias) {
		this.listaPreferencias = listaPreferencias;
	}

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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Telefone getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(Telefone telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public EnumPreferencias getEnumInteresses() {
		return enumPreferencias;
	}

	public void setEnumInteresses(EnumPreferencias enumPreferencias) {
		this.enumPreferencias = enumPreferencias;
	}





	



	









	
}
