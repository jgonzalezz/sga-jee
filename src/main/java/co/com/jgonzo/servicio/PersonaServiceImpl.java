package co.com.jgonzo.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import co.com.jgonzo.domain.Persona;
import co.com.jgonzo.eis.PersonaDao;

// ejb que implementa la interface remota y la interface local   CAPA DE SERVICIO
@Stateless
@WebService(endpointInterface="co.com.jgonzo.servicio.PersonaServiceWS")
public class PersonaServiceImpl implements PersonaServiceRemote , PersonaService, PersonaServiceWS{ 
	
	//Para integrar la capa de datos con esta la capa de sercio usamos una injeccion de deoendencias con la anotacion EJB
	@EJB
	private PersonaDao personaDao;
	// COn esto recuperamos una referencia que este en memoria
	
	//Indicamos que vamos a sobreescriber el metodo en en la interface PersonaServiceWS
	@Override
	public List<Persona> listarPersonas() {
		// un metodo de negocio en nuestra capa de servicio puede manejar diferentes DAOS
		//ej:   usuarioDAo.fin....
		return personaDao.findAllPersonas();
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDao.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}

}
