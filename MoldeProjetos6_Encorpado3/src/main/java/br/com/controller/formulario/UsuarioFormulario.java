package br.com.controller.formulario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Usuario;

@ApplicationScoped
@Named("usuarioFormulario")
public class UsuarioFormulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuario usuario;
	
	private List <Usuario> todosUsuarios=new ArrayList<Usuario>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}

	public void setTodosUsuarios(List<Usuario> todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}
}
