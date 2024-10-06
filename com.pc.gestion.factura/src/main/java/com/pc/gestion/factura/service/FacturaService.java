package com.pc.gestion.factura.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pc.gestion.factura.entity.Factura;
import com.pc.gestion.factura.feignclient.ClienteFeingClient;
import com.pc.gestion.factura.feignclient.ProductoFeingClient;
import com.pc.gestion.factura.repository.FacturaRepository;
import com.pc.gestion.factura.Iservice.IFactluraService;
import com.pc.gestion.factura.dto.ClienteDTO;
import com.pc.gestion.factura.dto.ProductoDTO;

@Service
public class FacturaService implements IFactluraService{
	@Autowired
	private  FacturaRepository facturaRepository;
	
	@Autowired
	private ClienteFeingClient clientecliente;
	
	@Autowired
	private ProductoFeingClient productocliente;

   
	//veficar si el cliente existe 
	 // Verificar si el cliente existe y crear la factura

	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Factura> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Factura save(Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
   
	}
	
