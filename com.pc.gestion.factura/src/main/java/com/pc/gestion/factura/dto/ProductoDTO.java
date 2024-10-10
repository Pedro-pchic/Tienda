package com.pc.gestion.factura.dto;

import java.math.BigDecimal;

public class ProductoDTO {
private Long id;
	
	private String nombre;
	private BigDecimal precio;
	private Integer stock;
	public Long getIdProducto() {
		return id;
	}
	public void setIdProducto(Long idProducto) {
		this.id = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
