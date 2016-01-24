package co.com.jgonzo.eis;

// eis enterprise information system   capa de datos
import java.util.List;

import co.com.jgonzo.domain.Persona;

//
public interface PersonaDao {
	
	// Todos los metodos reciben objetos
	
	public List<Persona> findAllPersonas();
	
	public Persona findPersonaById(Persona persona);
	
	public Persona findPersonaByEmail(Persona perona);
	
	public void insertPersona(Persona persona);
	
	public void updatePersona(Persona persona);
	
	public void deletePersona(Persona persona);
	

}
