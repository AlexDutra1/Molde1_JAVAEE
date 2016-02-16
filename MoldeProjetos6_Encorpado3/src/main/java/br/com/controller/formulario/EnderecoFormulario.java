package br.com.controller.formulario;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Endereco;
import br.com.modelo.Estado;

@Named("enderecoFormulario")
@ApplicationScoped
public class EnderecoFormulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Endereco endereco;

	@Inject
	private Estado estadoSelecionado;
	
	private List <Estado> todosEstados;
	
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
}
