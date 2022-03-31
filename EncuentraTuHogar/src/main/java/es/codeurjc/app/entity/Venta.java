package es.codeurjc.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fechaVenta;
	private Double precioVenta;
	
	@OneToOne
	private User vendedor;
	    
	@OneToOne
	private User comprador;
	    
	@OneToOne
	private Casa casa;
	    
	public Venta() {
	}

	public Venta(String fechaVenta, Double precioVenta) {
		this.fechaVenta = fechaVenta;
		this.precioVenta = precioVenta;
		this.vendedor = new User();
		this.comprador = new User();
		this.casa = new Casa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public User getVendedor() {
		return vendedor;
	}

	public void setVendedor(User vendedor) {
		this.vendedor = vendedor;
	}

	public User getComprador() {
		return comprador;
	}

	public void setComprador(User comprador) {
		this.comprador = comprador;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha venta=" + fechaVenta + 
				","+ " precio venta=" + precioVenta + "]";
	}

}