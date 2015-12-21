package br.com.persistencia.implementacao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.modelo.Usuario;
import br.com.persistencia.interfaces.UsuarioGerenciable;

public class UsuarioDAO implements UsuarioGerenciable {

	private EntityManager manager;
	
	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void guardar(Usuario usuario) {
		
		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		usuario=this.manager.merge(usuario);
		this.manager.merge(usuario);
		
		trx.commit();
		
	}

}
