package br.com.persistencia.implementacao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.modelo.Estado;
import br.com.modelo.Municipio;
import br.com.modelo.Usuario;
import br.com.persistencia.interfaces.MunicipioGerenciable;

public class MunicipioDAO implements MunicipioGerenciable {

private EntityManager manager;
	
	@Inject
	public MunicipioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/* 
	 * Permite fazer o CREATE e UPDATE
	 */
	public void guardar(Municipio municipio) {

		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		municipio=this.manager.merge(municipio);
		this.manager.merge(municipio);
		
		trx.commit();
		
	}
	//PRECISA TESTAR
	@SuppressWarnings("unchecked")
	public List <Municipio> consultaMunicipiosPeloEstado(Estado estado){
		
		Query consulta=manager.createQuery("select a from Municipio a where idmunicipio='"+estado.getId()+"'", Municipio.class);
		
		return consulta.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List <Municipio> consultaTodosMunicipios(){
		
		Query consulta=manager.createQuery("select a from Municipio a ", Municipio.class);
		
		return consulta.getResultList();
		
	}
	

}
