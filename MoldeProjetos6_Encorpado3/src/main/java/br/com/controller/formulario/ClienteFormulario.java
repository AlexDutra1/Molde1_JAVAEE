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
import br.com.modelo.Municipio;
import br.com.modelo.Telefone;
import br.com.modelo.enums.EnumGenero;
import br.com.modelo.enums.EnumPreferencias;




@Named
@ApplicationScoped
public class ClienteFormulario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Cliente cliente;
	
	@Inject
	private Endereco endereco;
	
	@Inject
	private Telefone telefone;
	
	@Inject
	private Interesse interesse;
	
	@Inject
	private Estado estadoSelecionado;
	
	@Inject
	private Municipio municipioSelecionado;
	
	private List <Cliente> todosClientes;

	private List <Estado> todosEstados;
	
	private List <Municipio> todosMunicipios;
	
	private List <Municipio> municipiosDoEstado;
	
	private List <Interesse> listaInteresses= new ArrayList<Interesse>();
	
	private List <String> listaPreferencias;
	
	private List <Telefone> listaTelefones= new ArrayList<Telefone>();
	
	private EnumPreferencias enumPreferencias;
	
	private EnumGenero enumGenero;
	
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

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}

	public void setTodosClientes(List<Cliente> todosClientes) {
		this.todosClientes = todosClientes;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public EnumPreferencias getEnumInteresses() {
		return enumPreferencias;
	}

	public void setEnumInteresses(EnumPreferencias enumPreferencias) {
		this.enumPreferencias = enumPreferencias;
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

	public Estado getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(Estado estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public List<Municipio> getTodosMunicipios() {
		return todosMunicipios;
	}

	public void setTodosMunicipios(List<Municipio> todosMunicipios) {
		this.todosMunicipios = todosMunicipios;
	}

	public Municipio getMunicipioSelecionado() {
		return municipioSelecionado;
	}

	public void setMunicipioSelecionado(Municipio municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
	}

	public EnumGenero getEnumGenero() {
		return enumGenero;
	}

	public void setEnumGenero(EnumGenero enumGenero) {
		this.enumGenero = enumGenero;
	}

	public List<Municipio> getMunicipiosDoEstado() {
		return municipiosDoEstado;
	}

	public void setMunicipiosDoEstado(List<Municipio> municipiosDoEstado) {
		this.municipiosDoEstado = municipiosDoEstado;
	}

	





	



	









	
}
