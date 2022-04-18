package es.codeurjc.app.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Entity

//Esta en la jerarquía superior con @Repository, @Controller, @Service
//Permite anotar un bean para que Sprint lo considere un de sus objetos
@Component

/*Cuando se visita la página por primera vez se incia la sesión. 
Cualquier página que se abra dentro del mismo navegador comparte la sesión*/
@SessionScope
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private String password;
	private String dni;
	private String email;
	
	
	//El atributo mappedBy define el objeto al que pertenece la relación
	//y es obligatorio si la relación es bidireccional
	@OneToMany (mappedBy="usuario")
	private List<Anuncio> anuncio;
	
	@OneToMany (mappedBy="propietario")
	private List<Casa> casa;
	
	@OneToOne(cascade = CascadeType.ALL) //ambos objetos de la relación tienen el mismo ciclo de vida
	private Venta venta;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private Compra compra;

	
	//Significa que la colección no es una colección de entidades, sino una colección de tipos simples
	@ElementCollection(fetch = FetchType.EAGER) //Roles del usuario Admin y o User
	//La relación debe ser cargada al momento de cargar la entidad (Ansioso EAGER)
	
	private List<String> roles;

	public User() {}

	public User(String name, String password, String dni, String mail, String... roles) {
		this.name = name;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.dni = dni;
		this.email = mail;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void removeAnuncio(Anuncio anuncio) {
		getAnuncio().remove(anuncio);
		anuncio.setUsuario(null);
	}

	public List<Anuncio> getAnuncio() {
		return anuncio;
	}

	public Venta getVenta() {
		return venta;
	}

	public List<Casa> getCasa() {
		return casa;
	}

	public void setCasa(List<Casa> casa) {
		this.casa = casa;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}