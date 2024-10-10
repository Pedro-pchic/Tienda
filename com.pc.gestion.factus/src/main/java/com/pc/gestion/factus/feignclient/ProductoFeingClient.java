package com.pc.gestion.factus.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pc.gestion.factus.dto.ProductoDTO;


@FeignClient(name="producto-service", url="http://localhost:8090")
@RequestMapping("api/productos")
public interface ProductoFeingClient {
	
	@GetMapping("/buscar/{id}")
	ProductoDTO findById(@PathVariable Long id);
}
