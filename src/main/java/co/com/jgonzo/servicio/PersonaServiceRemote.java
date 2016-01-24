package co.com.jgonzo.servicio;

import java.util.List;

import javax.ejb.Remote;

import co.com.jgonzo.domain.Persona;

//para convertir la interfaz en interfaz remota agregamos la anotacion @Remote

@Remote
public interface PersonaServiceRemote {

	public List<Persona> listarPersonas();

	public Persona encontrarPersonaPorId(Persona persona);

	public Persona encontrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);

}
