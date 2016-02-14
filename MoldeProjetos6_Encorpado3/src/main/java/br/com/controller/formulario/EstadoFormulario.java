package br.com.controller.formulario;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.modelo.Estado;


@Named
@ApplicationScoped
public class EstadoFormulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
