package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
@SequenceGenerator(name="USUARIO_SEQUENCE", sequenceName="USUARIO_SEQUENCE", allocationSize=1, initialValue=0)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USUARIO_SEQUENCE")
	private Long idUsuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="email")
	private String email;
	
	/*@OneToOne
	@Lob
	private Imagem imagem;
	*/

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
