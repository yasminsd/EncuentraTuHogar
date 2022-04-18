package es.codeurjc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Casa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String catastro;
	private int habitaciones;
	private double metros;
	private int anioConstruccion;
	private String localidad;
	private double precio;
	
	@ManyToOne //Relación de muchos a 1
	private User propietario;
	
	
	//Relación 1:1 y ambos objetos de la relación tienen el mismo ciclo de vida
	@OneToOne
	private Anuncio anuncio;

	protected Casa() {}

	public Casa(String catastro, int habitaciones, double metros,
			int anioConstruccion, String localidad, double precio, User propietario) {
		
		super();
		
		this.catastro = catastro;
		this.habitaciones = habitaciones;
		this.metros = metros;
		this.anioConstruccion = anioConstruccion;
		this.localidad = localidad;
		this.precio = precio;
		this.propietario = propietario;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCatastro() {
		return catastro;
	}

	public void setCatastro(String catastro) {
		this.catastro = catastro;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public double getMetros() {
		return metros;
	}

	public void setMetros(double metros) {
		this.metros = metros;
	}

	public int getAnioConstruccion() {
		return anioConstruccion;
	}

	public void setAnioConstruccion(int anioConstruccion) {
		this.anioConstruccion = anioConstruccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public User getPropietario() {
		return propietario;
	}

	public void setPropietario(User propietario) {
		this.propietario = propietario;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	@Override
	public String toString() {
		return "Casa [Catastro=" + catastro + 
				", habitaciones=" + habitaciones +
				", metros=" + metros +", año de construcción=" + anioConstruccion+ 
				", localidad="+ localidad +", precio=" + precio + "]";
	}

}
