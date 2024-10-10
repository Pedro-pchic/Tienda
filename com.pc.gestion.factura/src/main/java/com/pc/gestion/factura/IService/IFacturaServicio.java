package com.pc.gestion.factura.IService;

import java.util.List;
import java.util.Optional;

import com.pc.gestion.factura.entity.Factura;

public interface IFacturaServicio {
	Factura save(Factura factura);
	Optional<Factura> finById(Long id);
	List<Factura> findAll();
	void deleteById(Long id);
	Factura updateFactura(Long id, Factura factura);
	Optional<Factura> findById(Long id);
	
	
	

}
