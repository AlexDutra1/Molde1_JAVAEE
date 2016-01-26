package br.com.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

@Named("controllerCheckbox")
@ApplicationScoped
public class ControllerCheckbox implements Serializable {

	private static final long serialVersionUID = 1L;

	private List <String> listaInteresses;
	
	private String outroInteresse;
	
	public String getOutroInteresse() {
		return outroInteresse;
	}



	public void setOutroInteresse(String outroInteresse) {
		this.outroInteresse = outroInteresse;
	}



	public String exibeListaNoConsole(){
		listaInteresses.add(outroInteresse);
		//Atualiza tabela
		RequestContext.getCurrentInstance().update(Arrays.asList("formInteresses:tabelaInteresses"));
		
		return null;
	}



	public List<String> getListaInteresses() {
		return listaInteresses;
	}



	public void setListaInteresses(List<String> listaInteresses) {
		this.listaInteresses = listaInteresses;
	}




	
	
}
