package edu.curso.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Principal {

	public static void main(String[] args) {

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		//CategoriaProducto categoriaProducto = new CategoriaProducto();
		//categoriaProducto.setNombre("General");
		//session.save(categoriaProducto);
		
		
		Deposito deposito1 = new Deposito();
		deposito1.setNombre("Depo1");

		Deposito deposito2 = new Deposito();
		deposito2.setNombre("Depo2");

		session.save(deposito1);
		session.save(deposito2);

		Long idCategoria = 6L;
		CategoriaProducto categoriaProducto = session.get(CategoriaProducto.class, idCategoria);
		
		//ALTA
		Producto producto1 = new Producto("Ejemplo producto 4", 5000.0);
		producto1.setCategoriaProducto(categoriaProducto);
		producto1.getDepositos().add(deposito1);
		producto1.getDepositos().add(deposito2);
		session.save(producto1);
		System.out.println("El id generado del producto es: " + producto1.getId());

		
		//CONSULTA POR ID
		//Long idBuscar = 10L;
		//Producto productoRecuperado = session.get(Producto.class, idBuscar);
		//System.out.println(productoRecuperado);
		//CategoriaProducto categoriaProducto = productoRecuperado.getCategoriaProducto();
		//System.out.println(categoriaProducto);

		//for(Deposito deposito : productoRecuperado.getDepositos()) {
		//	System.out.println(deposito);
		//}
		
		//UPDATE
		//Long idBuscar = 1L;
		//Producto productoRecuperado = session.get(Producto.class, idBuscar);
		//System.out.println(productoRecuperado);
		//productoRecuperado.setNombre("Ejemplo producto 1 con update");
		//session.update(productoRecuperado);
		
		//Long idBuscar = 1L;
		//Producto productoRecuperado = session.get(Producto.class, idBuscar);
		//System.out.println(productoRecuperado);
		//productoRecuperado.setNombre("Ejemplo producto 1 con update");
		//session.delete(productoRecuperado);
		
		//Query<Producto> consultaProductos = session.createQuery("from Producto as p order by p.nombre", Producto.class);
		//List<Producto> productos = consultaProductos.list();
		
		//for (Producto p : productos) {
		//	System.out.println(p);
		//}
		
		transaction.commit();
		session.close();
		
		HibernateUtil.close();
		
		
	}

}
