package com.pc.gestion.factura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pc.gestion.factura.service.FacturaService;
import com.pc.gestion.factura.entity.factura;
import com.pc.gestion.factura.request.FacturaRequest;
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping("/save")
	public ResponseEntity<factura> crearFactura(@RequestBody FacturaRequest request){
		try {
			factura facturas = facturaService.crearFactura(request.getClienteId(), request.getProductosIds());
			return ResponseEntity.ok(facturas);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
