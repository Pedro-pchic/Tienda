package com.pc.gestion.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pc.gestion.factura.dto.ProductoDTO;

@FeignClient(name="producto-service", url="${producto.service.url}")
public interface ProductoFeingClient {
	@GetMapping("/api/productos/buscar/{id}")
	ProductoDTO getProducto(@PathVariable("id") Long id);
}
