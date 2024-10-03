package com.pc.gestion.factura.request;

import java.util.List;

public class FacturaRequest {
	private Long clienteId;
	private List<Long> productosIds;
	
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public List<Long> getProductosIds() {
		return productosIds;
	}
	public void setProductosIds(List<Long> productosIds) {
		this.productosIds = productosIds;
	}
	
	
}
