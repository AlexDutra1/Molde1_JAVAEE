package testes_unitarios.cliente;

import junit.framework.Assert;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ClienteTeste extends AppTeste{
	
	@Test
    public void should_create_greeting() {
        Assert.fail("Not yet implemented");
    }
/*
	@Inject
	ClasseTerapeutica entidade, entidadeAlt;
	
	@Inject
	ManterClasseTerapeuticaREST rest;
	
	@Test
	@InSequence(1)
	public void componentesNaoNulos() {
		assertNotNull(entidade);
		assertNotNull(rest);
	}
	
	@Test
	@InSequence(2)
	public void entidadeFoiPersistida() {
		entidade.setNome("Lorem ipsum dolor sit amet, consectetur adipiscing elit amet");
		entidade.setHistorico("Lorem ipsum dolor sit amet, consectetur adipiscing elit amet");
		entidade.setCuidados("Lorem ipsum dolor sit amet, consectetur adipiscing elit amet");
		rest.getService().inserir(entidade);
		assertNotNull(entidade.getId());
	}
*/
}
