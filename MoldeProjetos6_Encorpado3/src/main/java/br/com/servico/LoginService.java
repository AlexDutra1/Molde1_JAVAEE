package br.com.servico;

import javax.inject.Inject;

public class LoginService {
	
	@Inject
	private UsuarioService usuarioService;

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
