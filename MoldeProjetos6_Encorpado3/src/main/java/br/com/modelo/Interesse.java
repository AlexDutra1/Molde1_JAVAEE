package br.com.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_interesses")
@SequenceGenerator(name="INTERESSE_SEQUENCE", sequenceName="INTERESSE_SEQUENCE", allocationSize=1, initialValue=0)
public class Interesse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="INTERESSE_SEQUENCE")
	private Long idInteresse;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToMany(mappedBy="interesses")
    private List <Cliente> clientes;
	

	public Long getIdInteresse() {
		return idInteresse;
	}

	public void setIdInteresse(Long idInteresse) {
		this.idInteresse = idInteresse;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}
