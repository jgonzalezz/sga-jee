package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import co.com.jgonzo.domain.Persona;
import co.com.jgonzo.servicio.PersonaService;

public class PersonaServiceTest {
	//

	private PersonaService personaService;

	/**
	 * @throws Exception
	 *             Inicializar Contenedor Embebido
	 */
	@Before
	public void setUp() throws Exception {

		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) contenedor.getContext()
				.lookup("java:global/classes/PersonaServiceImpl!co.com.jgonzo.servicio.PersonaService");
	}
	
	//@Test
	public void testEJBPersonaService(){
		System.out.println("Iniciand test EJB PersonaService");
		
		assertTrue(personaService != null);
		
		assertEquals(5,personaService.listarPersonas().size());
		
		System.out.println("El # de personas es igual a:" + personaService.listarPersonas().size());
		
		this.desplegarPersonas(personaService.listarPersonas());
		System.out.println("Fin test EJB PersonaService ");
		
	}

	// metodo para mostrar en consola las personas de la lista
	private void desplegarPersonas(List<Persona> listarPersonas) {
		for (Persona persona : listarPersonas) {
			System.out.println(persona);
		}
		
	}
	

}
