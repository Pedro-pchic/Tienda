package com.pc.gestion.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pc.gestion.producto.entity.Producto;

@FeignClient(name ="producto-service", url="${producto.service.url}")
public interface ProductoClient {
	@GetMapping("/api/productos/{id}")
	Producto getProducto(@PathVariable("id") Long id);
}
