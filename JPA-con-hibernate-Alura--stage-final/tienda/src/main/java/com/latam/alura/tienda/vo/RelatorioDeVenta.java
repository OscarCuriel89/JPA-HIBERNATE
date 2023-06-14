package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
	
	private String NombreDelProducto;
	private Long CantidadDeProducto;
	private LocalDate FechaDeUltimaVenta;
	
	public RelatorioDeVenta(String nombreDelProducto, Long cantidadDeProducto, LocalDate fechaDeUltimaVenta) {
	
		NombreDelProducto = nombreDelProducto;
		CantidadDeProducto = cantidadDeProducto;
		FechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	public String getNombreDelProducto() {
		return NombreDelProducto;
	}

	public void setNombreDelProducto(String nombreDelProducto) {
		NombreDelProducto = nombreDelProducto;
	}

	public Long getCantidadDeProducto() {
		return CantidadDeProducto;
	}

	public void setCantidadDeProducto(Long cantidadDeProducto) {
		CantidadDeProducto = cantidadDeProducto;
	}

	public LocalDate getFechaDeUltimaVenta() {
		return FechaDeUltimaVenta;
	}

	public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
		FechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioDeVenta [NombreDelProducto=" + NombreDelProducto + ", CantidadDeProducto=" + CantidadDeProducto
				+ ", FechaDeUltimaVenta=" + FechaDeUltimaVenta + "]";
	}

}
