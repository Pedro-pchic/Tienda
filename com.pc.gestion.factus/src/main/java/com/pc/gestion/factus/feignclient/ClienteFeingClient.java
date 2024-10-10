package com.pc.gestion.factus.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.pc.gestion.factus.dto.ClienteDTO;

@FeignClient(name="cliente-service", url="http://localhost:8089")
@RequestMapping("/api/clientes")
public interface ClienteFeingClient {
	@GetMapping("buscar/{id}")
	ClienteDTO findById(@PathVariable Long id);
}
