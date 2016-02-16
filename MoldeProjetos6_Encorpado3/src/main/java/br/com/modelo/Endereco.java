package br.com.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_endereco")
@SequenceGenerator(name="ENDERECO_SEQUENCE", sequenceName="ENDERECO_SEQUENCE", allocationSize=1, initialValue=0)
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENDERECO_SEQUENCE")
	private Long idEndereco;

	private String lagradouro;
	
	private String quadra;
	
	private String lote;
	
	private String numero;
	
	private String cep;
	
	private String bairro;
	
	
	//RELACIONAMENTO ESTADO
	/*
	@ManyToOne
    @JoinColumn(name = "estado_id")
	private Estado estado;
	*/
	/*
	@ManyToOne
	@JoinColumn(name="idEstado", referencedColumnName="idEstado")
	*/
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstado")
	private Estado estado;
	

	
	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLagradouro() {
		return lagradouro;
	}

	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	

}
