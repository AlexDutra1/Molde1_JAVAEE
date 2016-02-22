package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelo.Interesse;

public class InteresseDAO {

	private EntityManager manager;
	
	@Inject
	public InteresseDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Interesse> consultarPorIdCliente(Long id) {
		
		Query consulta=manager.createQuery("SELECT a FROM Interesse a JOIN a.clientes u ON u.idCliente='"+id+"'",Interesse.class);
		
		return consulta.getResultList();
	}
}
