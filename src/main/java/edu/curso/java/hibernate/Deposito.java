package edu.curso.java.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deposito {
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
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
