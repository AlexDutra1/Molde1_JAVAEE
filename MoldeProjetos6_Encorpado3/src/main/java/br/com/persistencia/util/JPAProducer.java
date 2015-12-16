package br.com.persistencia.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAProducer {

	private EntityManagerFactory factory;
	
	public JPAProducer() {
		this.factory = Persistence.createEntityManagerFactory("default");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
