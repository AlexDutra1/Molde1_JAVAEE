package br.com.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.controller.formulario.LoginFormulario;
import br.com.servico.LoginService;


@Named("loginController")
@ApplicationScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginService service;
	
	@Inject
	private LoginFormulario formulario;
	
	public void autenticar(){
		
	}

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}

	public LoginFormulario getFormulario() {
		return formulario;
	}

	public void setFormulario(LoginFormulario formulario) {
		this.formulario = formulario;
	}

	
	}
