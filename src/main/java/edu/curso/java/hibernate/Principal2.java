package edu.curso.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Principal2 {

	public static void main(String[] args) {

		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query<Producto> consultaProductos = session.createQuery("from Producto as p where p.precio > :precio order by p.nombre ", Producto.class);
		consultaProductos.setParameter("precio", 2000.0);
		
		List<Producto> productos = consultaProductos.list();
		
		for (Producto p : productos) {
			System.out.println(p);
		}

		
		//Query<Producto> consultaProductosPorCategoria = session.createQuery("from Producto as p where p.categoriaProducto.id = :idCategoria order by p.nombre ", Producto.class);
		//consultaProductosPorCategoria.setParameter("idCategoria", 6L);
		
		Query<Producto> consultaProductosPorCategoria = session.createQuery("from Producto as p where p.categoriaProducto.nombre like :nombreCategoria order by p.nombre ", Producto.class);
		consultaProductosPorCategoria.setParameter("nombreCategoria", "%general%");		
		productos = consultaProductosPorCategoria.list();
		
		for (Producto p : productos) {
			System.out.println(p);
		}
		

		// select p.depositos from Producto as p where p.id = :idProducto"
		Query<Deposito> consultaDepositos = session.createQuery("select d from Producto as p inner join p.depositos as d where p.id = :idProducto", Deposito.class);
		consultaDepositos.setParameter("idProducto", 10L);		
		List<Deposito> despositos = consultaDepositos.getResultList();
		for (Deposito deposito : despositos) {
			System.out.println(deposito);
		}
		
		transaction.commit();
		session.close();
		
		HibernateUtil.close();
		
		
	}

}
