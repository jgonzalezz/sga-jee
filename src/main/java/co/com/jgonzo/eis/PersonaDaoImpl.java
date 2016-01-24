package co.com.jgonzo.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.jgonzo.domain.Persona;

@Stateless //EJB
public class PersonaDaoImpl implements PersonaDao {
	
	//Para poder interectuar con nuestra bd necesitamos un objeto de tipo Entity MAnager
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;

	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersonas() {
		//con el metodo createNamedQuery llamamos el query implementado en la entidad para seleccionar todas las personas
		return em.createNamedQuery("Persona.findAll").getResultList(); //Nos manda un warning podemos agregar el @SuppressWarnings("unchecked") pero ya sabemos que el metodo nos va retornar un objeto persona
		
		// si queremos crear el query con jpa podemos utilizar el metodo em.createQuery
		
	}

	public Persona findPersonaById(Persona persona) {
		return em.find(Persona.class, persona.getIdPersona());
		
	}

	public Persona findPersonaByEmail(Persona persona) {
		Query query = em.createQuery("from Persona p where p.email = :email"); // : y el nombre es un parametro dentro del query
		query.setParameter("email", persona.getEmail());
		return (Persona) query.getSingleResult(); // cast porque se retorna un objeto
	}

	public void insertPersona(Persona persona) {
		em.persist(persona);
	}

	public void updatePersona(Persona persona) {
		em.merge(persona); 
		//si el objeto persona no estaba detro de una transaccion el metodo merge lo
		//que hace es poner el objeto dentro de la transaccion para que pueda ser reconocido por la API de JPA
		//y revisar si existe alguna difeirencia con el registro que esta en memoria y el registro que hay en la bd
		// si existe alguna dif hacer el commit el api de jpa actualiza la nd de manera automatica
	}

	public void deletePersona(Persona persona) {
		
		em.merge(persona);// se recupera y pone en memoria
		em.remove(persona);// se remueve
		
	}

}
