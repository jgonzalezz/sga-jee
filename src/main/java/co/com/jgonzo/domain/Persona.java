package co.com.jgonzo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name="Persona.findAll",query="SELECT p FROM Persona p ORDER BY p.idPersona")})
@XmlAccessorType(XmlAccessType.FIELD) 
// Anotacion para no exponer el listado de usuarios ya que es una relacion, solo enviamos los atributos simples. 
//Si no tuvierasmos la relacion con usuario no se ingresaria la anotacion
//@XmlAccessorType(XmlAccessType.FIELD) Cada uno de los atributos de esta clase se va exponer como parte del servicio web, 
//ya que el metodo listar persona devuelve objetos persona
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="apellido_materno")
	private String apeMaterno;

	@Column(name="apellido_paterno")
	private String apePaterno;

	private String email;

	private String nombre;

	private String telefono;
	
	//Costructor Vacio
		public Persona(){
			
		}

		// Constructores
		public Persona(int idPersona, String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
			super();
			this.idPersona = idPersona;
			this.nombre = nombre;
			this.apePaterno = apePaterno;
			this.apeMaterno = apeMaterno;
			this.email = email;
			this.telefono = telefono;
		}
		
		public Persona(String nombre, String apePaterno, String apeMaterno, String email, String telefono) {
			super();
			this.nombre = nombre;
			this.apePaterno = apePaterno;
			this.apeMaterno = apeMaterno;
			this.email = email;
			this.telefono = telefono;
		}

	//Anotacion para excluir del web service la relacion con la tabla usuarios	
	@XmlTransient	
	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona", cascade={CascadeType.ALL})
	private Set<Usuario> usuarios;

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApeMaterno() {
		return this.apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getApePaterno() {
		return this.apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona 
				+ ", apePaterno=" + apePaterno
				+ ", apeMaterno=" + apeMaterno 
				+ ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apeMaterno == null) ? 0 : apeMaterno.hashCode());
		result = prime * result + ((apePaterno == null) ? 0 : apePaterno.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apeMaterno == null) {
			if (other.apeMaterno != null)
				return false;
		} else if (!apeMaterno.equals(other.apeMaterno))
			return false;
		if (apePaterno == null) {
			if (other.apePaterno != null)
				return false;
		} else if (!apePaterno.equals(other.apePaterno))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	

}