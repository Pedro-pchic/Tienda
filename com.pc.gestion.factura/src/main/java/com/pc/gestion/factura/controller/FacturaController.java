package com.pc.gestion.factura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pc.gestion.factura.service.FacturaService;

import jakarta.persistence.EntityNotFoundException;

import com.pc.gestion.factura.entity.Factura;
import com.pc.gestion.factura.request.FacturaRequest;
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping("/save")
	public ResponseEntity<?> crearFactura(@RequestBody FacturaRequest request) {
	    try {
	        // Validación de entrada
	        if (request.getClienteId() == null || request.getProductosIds() == null || request.getProductosIds().isEmpty()) {
	            return ResponseEntity.badRequest().body("El ID del cliente y los IDs de los productos son obligatorios.");
	        }
	        
	        Factura factura = facturaService.crearFactura(request.getClienteId(), request.getProductosIds());
	        return ResponseEntity.ok(factura);
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente o producto no encontrado: " + e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la factura: " + e.getMessage());
	    }
	}

}
