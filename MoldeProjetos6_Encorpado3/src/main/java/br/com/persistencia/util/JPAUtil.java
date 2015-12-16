package br.com.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("default");

	//CRIA E RETORNA CONEXAO QUANDO CHAMADO
	public static EntityManager pegaConexao(){
		
		return emf.createEntityManager();
	}
}
