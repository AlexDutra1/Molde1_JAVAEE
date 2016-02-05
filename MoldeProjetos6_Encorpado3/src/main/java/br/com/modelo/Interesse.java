package br.com.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_interesses")
public class Interesse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long idInteresse;
	
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
