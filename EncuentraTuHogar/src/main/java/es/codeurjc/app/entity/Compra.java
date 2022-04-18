package es.codeurjc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Compra {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String fechaOferta;
	private Double precioOferta;
	
	//Relación 1:1 y ambos objetos de la relación tienen el mismo ciclo de vida
    @OneToOne 
    private User comprador;
    
    @OneToOne
    private User vendedor;
    
	@OneToOne 
	private Casa casa;

	
	protected Compra() {}

	public Compra(String fechaOferta, Double precioOferta) {
		
		super ();
		this.fechaOferta = fechaOferta;
		this.precioOferta = precioOferta;
		this.comprador = new User();
		this.vendedor = new User();
		this.casa = new Casa();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFechaOferta() {
		return fechaOferta;
	}

	public void setFechaOferta(String fechaOferta) {
		this.fechaOferta = fechaOferta;
	}

	public Double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(Double precioOferta) {
		this.precioOferta = precioOferta;
	}

	public User getComprador() {
		return comprador;
	}

	public void setComprador(User comprador) {
		this.comprador = comprador;
	}

	public User getVendedor() {
		return vendedor;
	}

	public void setVendedor(User vendedor) {
		this.vendedor = vendedor;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return "Compra [Fecha oferta=" + fechaOferta + 
				","+ " precio oferta=" + precioOferta + "" + casa +"]";
	}
}