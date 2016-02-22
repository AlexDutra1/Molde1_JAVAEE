package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.modelo.Telefone;
import br.com.persistencia.interfaces.TelefoneGerenciable;

public class TelefoneDAO implements TelefoneGerenciable {

private EntityManager manager;
	
	@Inject
	public TelefoneDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Telefone> consultarPorIdCliente(Long id) {
		
		Query consulta=manager.createQuery("select a from Telefone a where cliente_id_fixo='"+id+"'",Telefone.class);
				
		return consulta.getResultList();
	}
}
