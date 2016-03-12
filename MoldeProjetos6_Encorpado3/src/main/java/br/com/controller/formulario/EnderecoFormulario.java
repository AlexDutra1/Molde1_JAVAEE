package br.com.controller.formulario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Municipio;

@Named
@ApplicationScoped
public class EnderecoFormulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Endereco endereco;

	@Inject
	private Estado estadoSelecionado;

	@Inject
	private Municipio municipioSelecionado;
	
	private List <Estado> todosEstados= new ArrayList<Estado>();;
	
	private List <Municipio> todosMunicipios= new ArrayList<Municipio>();
	
	private List <Endereco> todosEnderecos=new ArrayList<Endereco>();
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Estado> getTodosEstados() {
		return todosEstados;
	}

	public void setTodosEstados(List<Estado> todosEstados) {
		this.todosEstados = todosEstados;
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

	public List<Endereco> getTodosEnderecos() {
		return todosEnderecos;
	}

	public void setTodosEnderecos(List<Endereco> todosEnderecos) {
		this.todosEnderecos = todosEnderecos;
	}
}
