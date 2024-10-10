package com.pc.gestion.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.bind.annotation.RequestParam;

import com.pc.gestion.factura.dto.ProductoDTO;


@FeignClient(name ="producto-service", url ="${producto.servicio.url}")

public interface ProductoFeignClient {

	@GetMapping("/api/productos/buscar/{id}")
	ProductoDTO findById(@PathVariable("id") Long id);
	
	@PutMapping("/api/productos/{id}")
	ProductoDTO update(@PathVariable("id") Long id, @RequestParam("stock") int stock);
}
