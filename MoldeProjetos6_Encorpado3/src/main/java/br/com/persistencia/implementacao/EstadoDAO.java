package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelo.Estado;
import br.com.persistencia.interfaces.EstadoGerenciable;

public class EstadoDAO implements EstadoGerenciable{

	private EntityManager manager;
	
	@Inject
	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> todosEstadosCombo() {

		Query consulta=manager.createQuery("select a from Estado a",Estado.class);
		return consulta.getResultList();
		
	}

}
