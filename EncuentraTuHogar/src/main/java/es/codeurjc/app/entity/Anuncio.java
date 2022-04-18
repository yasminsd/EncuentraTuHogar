package es.codeurjc.app.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/*Una de las grandes ventajas de JPA es que nos permite manipular la base de datos
a través de objetos, estos objetos son conocidos como Entity, las cuales son clases
comunes, estas clases tiene la particularidad de ser clases que están mapeadas contra
una tabla de la base de datos que podemos ver con MySQLWorkBench una vez arrancada la aplicación*/

@Entity 
public class Anuncio {

	@Id //El atributo marcado con ID es la clave primaria de la tabla
	
	/*La anotacion @GeneratedValue con JPA es algo bastante habitual ya que existen 
	muchas tablas cuyas claves primarias preferimos que sean autoincrementales. 
	Así pues solemos configurar las entidades de JPA para que usen estas anotaciones.
	
	El GenerationType.AUTO es el tipo de generación por defecto y permite que el proveedor 
	de persistencia elegir la estrategia de generación.
	Si usa Hibernate como su proveedor de persistencia, selecciona una estrategia de generación
	basada en el dialecto específico de la base de datos*/
	
	@GeneratedValue(strategy = GenerationType.AUTO) //
	private long id = -1;

	private String nombre;
	private String asunto;

	@ManyToOne //Relación de muchos a 1
	private User usuario;

	
	//Relación 1:1 y ambos objetos de la relación tienen el mismo ciclo de vida
	@OneToOne (cascade = CascadeType.ALL) 
	private Casa casa;

	public Anuncio() {}

	public Anuncio(String nombre, String asunto) {
		this.nombre = nombre;
		this.asunto = asunto;
		this.usuario = new User();
		this.casa = new Casa();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return "Anuncio [nombre=" + nombre + ", asunto=" + asunto + "]";
	}

}