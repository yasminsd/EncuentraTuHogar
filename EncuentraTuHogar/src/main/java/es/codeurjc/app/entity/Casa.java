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
	private Long id = null;

	private String catastro;

	private Integer habitaciones;
	private Double metros;
	private Integer anioConstruccion;
	private String localidad;
	private Double precio;
	
	@ManyToOne
	private User propietario;
	
	@OneToOne
	private Anuncio anuncio;

	public Casa() {}

	public Casa(String catastro, Integer habitaciones, Double metros,
			Integer anioConstruccion, String localidad, Double precio) {
		super();
		this.catastro = catastro;
		this.habitaciones = habitaciones;
		this.metros = metros;
		this.anioConstruccion = anioConstruccion;
		this.localidad = localidad;
		this.precio = precio;
		this.propietario = propietario;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCatastro() {
		return catastro;
	}

	public void setCatastro(String catastro) {
		this.catastro = catastro;
	}

	public Integer getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Double getMetros() {
		return metros;
	}

	public void setMetros(Double metros) {
		this.metros = metros;
	}

	public Integer getAnioConstruccion() {
		return anioConstruccion;
	}

	public void setAnioConstruccion(Integer anioConstruccion) {
		this.anioConstruccion = anioConstruccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
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
		return "Casa [id=" + id + ", catastro=" + catastro + 
				", habitaciones=" + habitaciones +
				", metros=" + metros +", año de construcción=" + anioConstruccion+ 
				", localidad="+ localidad +", precio=" + precio + "]";
	}

}
