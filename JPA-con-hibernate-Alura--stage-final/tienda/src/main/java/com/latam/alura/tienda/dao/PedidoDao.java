package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.vo.RelatorioDeVenta;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	
	public void actualizar(Producto pedido) {
		this.em.merge(pedido);
	}
	
	public void remover(Pedido pedido) {
		pedido=this.em.merge(pedido);
		this.em.remove(pedido);
	}
	
	public Pedido consultaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public List<Pedido> consultarTodos(){
		String jqpl= "SELECT P FROM pedido AS P";
		return em.createQuery(jqpl,Pedido.class).getResultList();
	}
	
	public BigDecimal valorTotalVendido() {
		String jqpl= "SELECT SUM(p.valorTotal) FROM Pedido P";
		return em.createQuery(jqpl,BigDecimal.class).getSingleResult();
	}
	
	public List<Object[]> relatorioDeVentas(){
		String jpql= "SELECT Producto.nombre, "
				+"SUM(item.cantidad),"
				+"MAX(pedido.fecha)"
				+"FROM Pedido pedido "
				+"JOINT pedido.items item "
				+"JOINT item.producto producto"
				+"GROUP BY producto.nombre"
				+"ORDER BY item.cantidad DESC";
		return em.createQuery(jpql,Object[].class).getResultList();
	}
	
	
	public List<RelatorioDeVenta> relatorioDeVentasVo(){
		String jpql= "SELECT new com.latam.alura.tienda.vo.RelatorioDeVenta(producto.nombre, "
				+"SUM(item.cantidad),"
				+"MAX(pedido.fecha))"
				+"FROM Pedido pedido "
				+"JOINT pedido.items item "
				+"JOINT item.producto producto"
				+"GROUP BY producto.nombre"
				+"ORDER BY item.cantidad DESC";
		return em.createQuery(jpql,RelatorioDeVenta.class).getResultList();
	}
	
	public Pedido consultarPedidoConCliente(Long id) {
		String jpql= "SELECT p FROM Pedido p  JOINT FETCH p.cliente WHERE p.id=:id";
		return em.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}

}
