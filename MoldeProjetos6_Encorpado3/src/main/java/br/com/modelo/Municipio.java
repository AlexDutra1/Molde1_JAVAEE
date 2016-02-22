package br.com.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.controller.util.BaseEntity;

@Entity
@Table(name="tb_municipio")
public class Municipio implements BaseEntity,Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long idMunicipio;
	
	private String nome;
	
	//RELACIONAMENTO ESTADO
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstado")
	private Estado estado;
	
	public Long getId() {  
	       return new Long(idMunicipio);  
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
