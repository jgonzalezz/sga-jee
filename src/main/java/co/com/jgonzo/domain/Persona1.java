package co.com.jgonzo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// las clases de entidad deben implemetar el serializable
//Esta clase debido a que se va enviar por la red debido a que estamos utilizando el protocolo RMI,
//y podreiamos recibir llmadas desde fuera de este servidor necesitasmo que esta clase sea de tipo serializable, simplemente 
//implementando esta interfaz es posible enviar esta clase a travez de la red en llamadas remotas.
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
// Clase de entidad elaborada manualmente, la clase Persona se elaboro con ingenieria Inversa

@Entity
//Esta clase puede tener querys declarados en la misma clase JPQL
@NamedQueries({@NamedQuery(name="Persona.findAl",query="SELECT p FROM Persona p ORDER BY p.idPersona")})
@Table(name="persona")
public class Persona1 implements Serializable{

	private static final long serialVersionUID = 1L;
		
	// notacion de llave primaria @Id y de tipo autoincrementable
	// @........(...... .IDENTITY) y el nombre ed la columna en la bd
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;
	
	
    //como en BD el nombre es igual , el atributo name="nombre" no es necesario
	//nullable=false ==> no permite valores nulos
	@Column(nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido_paterno", nullable=false,length=45)
	private String apePaterno;
	
	@Column(name="apellido_materno", length=45)
	private String apeMaterno;
	
	@Column(length=45)
	private String email;
	
	@Column(length=45)
	private String telefono;
	
	//Costructor Vacio
	public Persona1(){
		
	}

	// Constructores
	public Persona1(int idPersona, String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Persona1(String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.email = email;
		this.telefono = telefono;
	}

	
	// Metodo que se genera con el source; se utiliza desde cliente cuando mostremos el listado
	//de personas recuperados desde el ejb
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apePaterno=" + apePaterno + ", apeMaterno="
				+ apeMaterno + ", email=" + email + ", telefono=" + telefono + "]";
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
