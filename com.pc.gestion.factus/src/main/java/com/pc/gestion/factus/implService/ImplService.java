package com.pc.gestion.factus.implService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pc.gestion.factus.Iservice.IService;
import com.pc.gestion.factus.dto.ClienteDTO;
import com.pc.gestion.factus.entity.Factura;
import com.pc.gestion.factus.feignclient.ClienteFeingClient; 
import com.pc.gestion.factus.feignclient.ProductoFeingClient;
import com.pc.gestion.factus.repository.Repository;

public class ImplService implements IService {

	@Autowired
	private  Repository facturaRepository;
	
	@Autowired
	private ClienteFeingClient clientecliente;
	
	@Autowired
	private ProductoFeingClient productocliente;

	@Override
	public Factura createFactura(Long clienteId, List<Long> productoIds) {
		clientecliente.findById(clienteId);
		
		//calcular el total
		BigDecimal total  =BigDecimal.ZERO;
		for(Long productoId : productoIds) {
			ProductoDTO producto = productocliente.findById(productoId);
			total = total.add(producto.getPrecio());
		}
		
		Factura factura = new Factura();
		factura.setClienteId(clienteId);
		factura.setListaproductos(productoIds);
		factura.setTotal(total);
		
		
		return facturaRepository.save(factura);
	}


	@Override
	public List<Factura> getAllFacturas() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura getFacturaById(Long id) {
		return facturaRepository.findById(id)
			.orElseThrow(() -> new RuntimeException("Factura no encotrado con id : " + id));
 	} 

	@Override
	public Factura updateFactura(Long id, Factura facturaDetails) {
		Factura factura = getFacturaById(id);
		factura.setClienteId(facturaDetails.getClienteId());
		factura.setListaproductos(facturaDetails.getListaproductos());
		factura.setTotal(facturaDetails.getTotal());
		return facturaRepository.save(factura);
		
	}

	@Override
	public void deleteFactura(Long id) {
		Factura factura = getFacturaById(id);
		facturaRepository.delete(factura);
		
	}

}
