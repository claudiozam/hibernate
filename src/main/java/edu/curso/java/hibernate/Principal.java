package edu.curso.java.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Principal {

	public static void main(String[] args) {

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//Producto producto1 = new Producto("Ejemplo producto 1", 5000.0);
		
		//session.save(producto1);

		//System.out.println("El id generado del producto es: " + producto1.getId());

		Long idBuscar = 1L;
		Producto productoRecuperado = session.get(Producto.class, idBuscar);
		System.out.println(productoRecuperado);
		
		
		transaction.commit();
		session.close();
		
		HibernateUtil.close();
		
		
	}

}
