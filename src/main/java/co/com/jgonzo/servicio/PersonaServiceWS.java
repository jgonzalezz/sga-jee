package co.com.jgonzo.servicio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import co.com.jgonzo.domain.Persona;

@WebService
public interface PersonaServiceWS {

	@WebMethod
	public List<Persona> listarPersonas();

}
