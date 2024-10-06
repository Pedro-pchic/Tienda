package com.pc.gestion.factura.Iservice;

import java.util.List;
import java.util.Optional;

import com.pc.gestion.factura.entity.Factura;
public interface IFactluraService {
	List<Factura> findAll();
	Optional<Factura> findById(Long id);
	Factura save(Factura factura);
	void deleteById(Long id);
}
