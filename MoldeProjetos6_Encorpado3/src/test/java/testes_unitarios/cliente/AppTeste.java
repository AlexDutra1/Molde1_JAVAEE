package testes_unitarios.cliente;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import br.com.modelo.Cliente;

public class AppTeste {
	
	@Deployment
	public static WebArchive createDeployment() {
		File[] dependencias = Maven.resolver().loadPomFromFile("pom.xml")
				.importRuntimeAndTestDependencies().resolve()
				.withTransitivity().asFile();

		WebArchive arquivo = ShrinkWrap
				.create(WebArchive.class, "MoldeProjetos1.war")
				.addPackages(true, "br.com")
				.addAsLibraries(dependencias)
				.addAsResource("beans.xml", "META-INF/beans.xml")
				.addAsResource("test-persistence.xml","META-INF/persistence.xml");
				
		
		/*
 * BACKUP
		WebArchive arquivo = ShrinkWrap
				.create(WebArchive.class, "molde1_teste.war")
				.addPackages(true, "br.com")
				.addAsLibraries(dependencias)
				.addAsResource("test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsResource("beans.xml", "META-INF/beans.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
*/
		System.out.println(arquivo.toString(true));

		return arquivo;
	}
}
