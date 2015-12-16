package br.com.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class UsuarioController {

	
	
	public String abreCadastro(){
		
		return "cadastroUsuario";
	}
	
	
	public String abrePesquisa(){
		
		return "pesquisaUsuario";
	}
	
	
}
