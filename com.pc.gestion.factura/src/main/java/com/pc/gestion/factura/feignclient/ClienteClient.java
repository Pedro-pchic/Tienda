package com.pc.gestion.factura.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pc.gestion.cliente.entity.Cliente;

@FeignClient(name = "cliente-service", url="${cliente.service.url}")
public interface ClienteClient {
	@GetMapping("/api/clientes/{id}")
	Cliente getCliente(@PathVariable("id")Long id);
		

}
