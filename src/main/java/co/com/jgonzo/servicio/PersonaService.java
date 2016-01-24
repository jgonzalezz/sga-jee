package co.com.jgonzo.servicio;

import java.util.List;

import javax.ejb.Local;

import co.com.jgonzo.domain.Persona;

// contiene los mismos metodos que la interfaz remota

@Local
public interface PersonaService {

	public List<Persona> listarPersonas();

	public Persona encontrarPersonaPorId(Persona persona);

	public Persona encontrarPersonaPorEmail(Persona persona);

	public void registrarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);

}
