package com.pc.gestion.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pc.gestion.factura.dto.ClienteDTO;

@FeignClient(name = "cliente-service", url = "${cliente.servicio.url}")
public interface ClienteFeignClient {
	
	@GetMapping("/api/clientes/buscar/{id}")
	ClienteDTO findById(@PathVariable("id") Long id);
}
