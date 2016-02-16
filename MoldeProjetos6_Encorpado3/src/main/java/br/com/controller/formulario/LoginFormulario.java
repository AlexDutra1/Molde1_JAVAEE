package br.com.controller.formulario;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Usuario;

@ApplicationScoped
@Named("loginFormulario")
public class LoginFormulario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}


