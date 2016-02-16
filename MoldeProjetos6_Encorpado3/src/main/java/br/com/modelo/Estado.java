package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.controller.util.BaseEntity;

@Entity
@Table(name="tb_estado")
@SequenceGenerator(name="ESTADO_SEQUENCE", sequenceName="ESTADO_SEQUENCE", allocationSize=1, initialValue=0)
public class Estado implements BaseEntity,Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ESTADO_SEQUENCE")
	private Long idEstado;
	
	private String nome;
	
	private String sigla;
	
	/*
	@Override
	public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	    	
	    		if ((obj instanceof Estado) && 
	    				((Estado) obj).getNome().equals(this.getNome()))
	    		{
	    			return true;
	    		}else
	    			return false;
	}*/
	
	/*    
	@Override
	public int hashCode() {
	// TODO Auto-generated method stub

		return getNome().length() * 8;
	}
	*/

	public Long getId() {  
	       return new Long(idEstado);  
	}
	
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getSigla() {
		return sigla;
	}



	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	

}
