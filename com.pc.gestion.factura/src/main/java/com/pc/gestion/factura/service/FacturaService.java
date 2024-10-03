package com.pc.gestion.factura.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.gestion.cliente.entity.Cliente;
import com.pc.gestion.factura.entity.factura;
import com.pc.gestion.factura.feignclient.ClienteClient;
import com.pc.gestion.factura.feignclient.ProductoClient;
import com.pc.gestion.factura.repository.FacturaRepository;
import com.pc.gestion.producto.entity.Producto;

@Service
public class FacturaService {
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Autowired
	private ClienteClient clientecliente;
	
	@Autowired
	private ProductoClient productocliente;
	//veficar si el cliente existe 
	public factura crearFactura(Long clienteId, List<Long> productoIds) {
		Cliente cliente = clientecliente.getCliente(clienteId);
		if(cliente == null) {
			throw new RuntimeException("cliente no encontrado");
		}
	
		//calcular el total y verificar el stock
		BigDecimal total = BigDecimal.ZERO;
		for(Long productoId : productoIds) {
			Producto producto = productocliente.getProducto(clienteId);
			if(producto == null || producto.getStock() <= 0) {
				throw new RuntimeException("producto no disponible "+ productoIds);
			}
			total = total.add(producto.getPrecio());
		}
		
		factura factura = new factura();
		factura.setClienteId(clienteId);
		factura.setListaproductos(productoIds);
		factura.setTotal(total);
		return facturaRepository.save(factura);
	}
	}
	
