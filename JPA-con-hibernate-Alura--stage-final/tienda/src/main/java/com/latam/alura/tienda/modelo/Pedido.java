package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha;
	private BigDecimal valorTotal = new BigDecimal(0);
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	private List<ItemsPedido> items=new ArrayList<>();
	
	public Pedido() {}


	public void agregarItems(ItemsPedido item) {
		item.setPedido(this);
		this.items.add(item);
		this.valorTotal= this.valorTotal.add(item.getValor());
	}


	public Pedido(Cliente cliente) {
		
		this.cliente = cliente;
	}





	public Long getId() {
		return id;
	}











}
