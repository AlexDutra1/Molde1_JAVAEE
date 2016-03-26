package br.com.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.modelo.enums.EnumGenero;

@Entity
@Table(name="tb_cliente")
@SequenceGenerator(name="CLIENTE_SEQUENCE", sequenceName="CLIENTE_SEQUENCE", allocationSize=1, initialValue=0)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CLIENTE_SEQUENCE")
	private Long idCliente;
	
	@Column(name="nome",nullable=true)
	private String nome;
	
	@Column(name="email",nullable=true)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento",nullable=true)
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="genero",nullable=true)
	private EnumGenero genero;
	
	@Column(precision=7,scale=3, name="renda",nullable=true)
	private BigDecimal rendaMensal;
	
	//RELACIONAMENTO ENDERECO OK
	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="endereco_id", nullable=true)
    @PrimaryKeyJoinColumn
	private Endereco endereco;
	
	//Faz o mapeamento na entidade telefone. A coluna que faz a ligação foi nomeada com cliente_id_fixo
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER )
	@JoinColumn(name="cliente_id_telefone",nullable=true)
	private List <Telefone> telefone;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tb_cliente_tem_interesses", joinColumns={@JoinColumn(name="idCliente")}, inverseJoinColumns={@JoinColumn(name="idInteresse")})
	private List <Interesse> interesses;
	
	/*
	@Column(name="preferencias")
	private List <String> listaPreferencias;
	*/


	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EnumGenero getGenero() {
		return genero;
	}

	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public List<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}


	
	
}
