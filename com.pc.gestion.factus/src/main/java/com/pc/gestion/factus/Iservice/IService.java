package com.pc.gestion.factus.Iservice;

import java.util.List;

import com.pc.gestion.factus.entity.Factura;

public interface IService {
	Factura createFactura(Long clienteId, List<Long> productoIds);
	List<Factura> getAllFacturas();
	Factura getFacturaById(Long id);
	Factura updateFactura(Long id, Factura factura);
	void deleteFactura(Long id);
}
