package edu.curso.java.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Deposito {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	@ManyToOne
	private Producto producto;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Deposito [id=" + id + ", nombre=" + nombre + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
