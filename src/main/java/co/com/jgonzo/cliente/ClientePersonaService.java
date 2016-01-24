package co.com.jgonzo.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.com.jgonzo.domain.Persona;
import co.com.jgonzo.servicio.PersonaServiceRemote;

//video 23
//CLiente Remoto: Se va a conectar via JNDi a nuestro servidor y va solicitar una instancia de nuestro ejb PersonaServiceImpl.java
public class ClientePersonaService {

	public static void main(String[] args) {
		System.out.println("Inciando llamada al EJB desde el cliente\n");

		// conexion JNDI verificar dependiendo del servidor de aplicaciones como
		// se implementa
		try {
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) jndi
					.lookup("java:global/sga-web/PersonaServiceImpl!co.com.jgonzo.servicio.PersonaServiceRemote");

			List<Persona> personas = personaService.listarPersonas();

			for (Persona persona : personas) {

				// Solo con tener el metodo toString en la clase persona podemos
				// pasar solo el objeto persona
				System.out.println(persona);
			}

			System.out.println("\nFin llamada al EJB desde el Cliente");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
