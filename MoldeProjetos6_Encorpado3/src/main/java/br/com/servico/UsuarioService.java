package br.com.servico;

import javax.inject.Inject;

import br.com.negocios.UsuarioNegocios;

public class UsuarioService {

	@Inject
	private UsuarioNegocios negocios;

	public UsuarioNegocios getNegocios() {
		return negocios;
	}

	public void setNegocios(UsuarioNegocios negocios) {
		this.negocios = negocios;
	}
	
	
}
