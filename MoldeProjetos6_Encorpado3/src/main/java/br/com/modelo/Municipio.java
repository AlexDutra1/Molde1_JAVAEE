package br.com.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.controller.util.BaseEntity;

@Entity
@Table(name="tb_municipio")
@SequenceGenerator(name="MUNICIPIO_SEQUENCE", sequenceName="MUNICIPIO_SEQUENCE", allocationSize=1, initialValue=0)
public class Municipio implements BaseEntity,Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MUNICIPIO_SEQUENCE")
	private Long idMunicipio;
	
	private String nome;
	
	//RELACIONAMENTO ESTADO
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idEstado")
	private Estado estado;
	
	//Torna Bidirecional
    @OneToOne(mappedBy = "municipio")
	private Endereco endereco;
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
