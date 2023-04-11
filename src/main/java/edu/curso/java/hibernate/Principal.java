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
		//Long idCategoria = 6L;
		//CategoriaProducto categoriaProducto = session.get(CategoriaProducto.class, idCategoria);
		//ALTA
		//Producto producto1 = new Producto("Ejemplo producto 4", 5000.0);
		//producto1.setCategoriaProducto(categoriaProducto);
		//session.save(producto1);
		//System.out.println("El id generado del producto es: " + producto1.getId());

		//CONSULTA POR ID
		Long idBuscar = 10L;
		Producto productoRecuperado = session.get(Producto.class, idBuscar);
		System.out.println(productoRecuperado);
		CategoriaProducto categoriaProducto = productoRecuperado.getCategoriaProducto();
		System.out.println(categoriaProducto);

		
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
