package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.modelo.Usuario;
import br.com.persistencia.interfaces.UsuarioGerenciable;

public class UsuarioDAO implements UsuarioGerenciable {

	private EntityManager manager;
	
	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public String autenticar(Usuario usuario){
		
		Query consulta=manager.createQuery("select a from Usuario a where usuario='"
				+usuario.getUsuario()
				+"' AND senha='"+usuario.getSenha()
				+"'", Usuario.class);
		
		@SuppressWarnings("unchecked")
		List <Usuario> lista =consulta.getResultList();
				
		if(lista.isEmpty()==true){
			return "recusado";
		}else{
			return "autenticado";
		}
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
