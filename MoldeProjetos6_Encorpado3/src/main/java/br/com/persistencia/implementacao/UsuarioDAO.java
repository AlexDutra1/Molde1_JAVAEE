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
	
	public List <Usuario> pesquisarComCriterios(Usuario usuario){
		
		//CRITERIA HIBERNATE-PARA IMPLEMENTAR
		/*
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Usuario.class);
		if(usuario.getNome() != null){
		criteria.add(Restrictions.eq("nome", usuario.getNome()));
		}
		if(usuario.getEmail() != null){
		criteria.add(Restrictions.eq("idade", usuario.getEmail()));
		}
		
		List<Usuario> list = criteria.list();
		
		for (Usuario usuario2 : list) {
			System.out.println("LISTA GERADO PELOS CRITERIOS: "+usuario2.getNome());
		}
		
		return list;
		 */
		
		//CRITERIA JPA
		
		CriteriaBuilder criteriaBuilder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery =
		criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		
		List<Predicate> condicoes = new ArrayList<Predicate>();
		
		if(!usuario.getNome().equals("")){
		Path<String> atributoNome = root.get("nome");
		Predicate whereNome = criteriaBuilder.like(atributoNome, usuario.getNome());
		condicoes.add(whereNome);
		}
		
		if(!usuario.getEmail() .equals("")){
		Path<String> atributoEmail = root.get("email");
		Predicate whereEmail = criteriaBuilder.like(atributoEmail, usuario.getEmail());
		condicoes.add(whereEmail);
		}
		
		if(!usuario.getUsuario() .equals("")){
		Path<String> atributoUsuario = root.get("usuario");
		Predicate whereUsuario = criteriaBuilder.like(atributoUsuario, usuario.getUsuario());
		condicoes.add(whereUsuario);
		}
		
		Predicate[] condicoesComoArray =
		condicoes.toArray(new Predicate[condicoes.size()]);
		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);
		criteriaQuery.where(todasCondicoes);

		TypedQuery<Usuario> query =this.manager.createQuery(criteriaQuery);
		
		List <Usuario> list=query.getResultList();
		
		for (Usuario usuario2 : list) {
			System.out.println("TESTE SENHA: "+usuario2.getSenha());
		}
		
		return list;
	
	}
	
	@SuppressWarnings("unchecked")
	public List <Usuario> pesquisaPorNome(String nome){
		
		Query consulta=manager.createQuery("select a from Usuario a where nome='"
				+nome+"'", Usuario.class);
		
		return consulta.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List <Usuario> pesquisaPorLogin(String login){
		Query consulta=manager.createQuery("select a from Usuario a where usuario='"
				+login+"'", Usuario.class);
		
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List <Usuario> pesquisarPorEmail(String email){

		Query consulta=manager.createQuery("select a from Usuario a where email='"
				+email+"'", Usuario.class);
		
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> consultarTodosUsuariosDAO(){
		
		Query consulta=manager.createQuery("select a from Usuario a", Usuario.class);
		
		return consulta.getResultList();
	}
	
}
