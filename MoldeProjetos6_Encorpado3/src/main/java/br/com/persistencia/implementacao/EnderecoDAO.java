package br.com.persistencia.implementacao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.modelo.Endereco;
import br.com.modelo.Estado;
import br.com.modelo.Municipio;
import br.com.persistencia.interfaces.EnderecoGerenciable;

public class EnderecoDAO implements EnderecoGerenciable {

private EntityManager manager;
	
	@Inject
	public EnderecoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	/* 
	 * Permite fazer o CREATE e UPDATE
	 */
	@Override
	public void guardar(Endereco endereco) {

		EntityTransaction trx = this.manager.getTransaction();
		trx.begin();
		
		endereco=this.manager.merge(endereco);
		this.manager.merge(endereco);
		
		trx.commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> consultarTodosClientesDAO(){
		
		Query consulta=manager.createQuery("select a from Endereco a",Endereco.class);
		
		return consulta.getResultList();
	}
	
	public List<Endereco> pesquisaComCriterios(Endereco endereco, Estado estado, Municipio municipio){
		
		//CRITERIA JPA
		
		CriteriaBuilder criteriaBuilder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Endereco> criteriaQuery =
		criteriaBuilder.createQuery(Endereco.class);
		Root<Endereco> root = criteriaQuery.from(Endereco.class);
		
		List<Predicate> condicoes = new ArrayList<Predicate>();
		
		if(!endereco.getLagradouro().equals("")){
		Path<String> atributoLagradouro = root.get("lagradouro");
		Predicate whereLagradouro = criteriaBuilder.like(atributoLagradouro, endereco.getLagradouro());
		condicoes.add(whereLagradouro);
		}
		
		if(!endereco.getQuadra() .equals("")){
		Path<String> atributoQuadra = root.get("quadra");
		Predicate whereQuadra = criteriaBuilder.like(atributoQuadra, endereco.getQuadra());
		condicoes.add(whereQuadra);
		}
		
		if(!endereco.getLote() .equals("")){
		Path<String> atributoLote = root.get("lote");
		Predicate whereLote = criteriaBuilder.like(atributoLote, endereco.getLote());
		condicoes.add(whereLote);
		}
		
		if(!endereco.getNumero() .equals("")){
		Path<String> atributoNumero = root.get("numero");
		Predicate whereNumero = criteriaBuilder.like(atributoNumero, endereco.getNumero());
		condicoes.add(whereNumero);
		}
			
		if(!endereco.getBairro() .equals("")){
		Path<String> atributoBairro = root.get("bairro");
		Predicate whereBairro = criteriaBuilder.like(atributoBairro, endereco.getBairro());
		condicoes.add(whereBairro);
		}
			
		if(!endereco.getCep() .equals("")){
		Path<String> atributoCep = root.get("cep");
		Predicate whereCep = criteriaBuilder.like(atributoCep, endereco.getCep());
		condicoes.add(whereCep);
		}
		
		//CRITERIA COM RELACIONAMENTOS
		
		//System.out.println("TESTANDO ESTADO: "+endereco.getEstado().getNome());
		//System.out.println("TESTANDO ESTADO: "+estado.getNome());
		
		if(!estado.getNome() .equals("")){
		Path<String> atributoEstado = root.get("estado");
		Predicate whereEstado = criteriaBuilder.equal(atributoEstado, estado);
		condicoes.add(whereEstado);
		}
		
		//APENAS MUNICIPIO NAO FUNCIONA
		/*
		if(!municipio.getNome() .equals("")){
		Path<String> atributoMunicipio = root.get("municipio");
		Predicate whereMunicipio = criteriaBuilder.equal(atributoMunicipio, municipio);
		condicoes.add(whereMunicipio);
		}
		*/
		
		/*
		if(!endereco.getMunicipio() .equals("")){
		Path<String> atributoMunicipio = root.get("municipio");
		Predicate whereMunicipio = criteriaBuilder.equal(atributoMunicipio, endereco.getMunicipio());
		condicoes.add(whereMunicipio);
		}
		*/
		
		Predicate[] condicoesComoArray =
		condicoes.toArray(new Predicate[condicoes.size()]);
		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);
		criteriaQuery.where(todasCondicoes);

		TypedQuery<Endereco> query =this.manager.createQuery(criteriaQuery);
		
		List <Endereco> list=query.getResultList();
		
		for (Endereco usuario2 : list) {
			System.out.println("TESTE : "+usuario2.getLagradouro());
		}
		
		return list;
	}

}
