package com.pc.gestion.factura.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "total")
    private BigDecimal total;

    @Lob
    @Column(name = "listaproductos", nullable = false)
    private List<Long> listaproductos; // Ahora es un String para almacenar la lista en formato JSON

    // Objeto para serializar/deserializar JSON
    private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public List<Long> getListaproductos() {
		return listaproductos;
	}
	public void setListaproductos(List<Long> listaproductos) {
		this.listaproductos = listaproductos;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
	
}
