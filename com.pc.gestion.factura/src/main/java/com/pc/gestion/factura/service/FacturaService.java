package com.pc.gestion.factura.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.gestion.cliente.entity.Cliente;
import com.pc.gestion.factura.IService.IFacturaServicio;
import com.pc.gestion.factura.dto.ClienteDTO;
import com.pc.gestion.factura.dto.ProductoDTO;
import com.pc.gestion.factura.entity.Factura;
import com.pc.gestion.factura.feignclient.ClienteFeignClient;
import com.pc.gestion.factura.feignclient.ProductoFeignClient;
import com.pc.gestion.factura.repository.FacturaRepository;
import com.pc.gestion.producto.entity.Producto;


@Service
public class FacturaService implements IFacturaServicio {
	
	@Autowired 
	private FacturaRepository facturaRepository;
	@Autowired
	private ClienteFeignClient clienteFactura;
	@Autowired
	private ProductoFeignClient productoFactura;
	

	 public Factura save(Factura factura) {
	        // Validar si el cliente existe
	        ClienteDTO cliente = clienteFactura.findById(factura.getClienteId());
	        if (cliente == null) {
	            throw new RuntimeException("El cliente con ID " + factura.getClienteId() + " no existe");
	        }

	        // Validar si los productos existen y calcular el total
	        BigDecimal total = BigDecimal.ZERO;
	        for (Long productoId : factura.getListaproductos()) {
	            ProductoDTO producto = productoFactura.findById(productoId);
	            if (producto == null) {
	                throw new RuntimeException("El producto con ID " + productoId + " no existe");
	            }
	            // Sumar el precio de cada producto al total
	            total = total.add(producto.getPrecio());

	            // Reducir el stock del producto
	            productoFactura.update(productoId, producto.getStock() - 1);
	        }

	        // Establecer el total de la factura
	        factura.setTotal(total);

	        // Guardar la factura
	        return facturaRepository.save(factura);
	    }

	    public Optional<Factura> findById(Long id) {
	        return facturaRepository.findById(id);
	    }

	    public List<Factura> findAll() {
	        return facturaRepository.findAll();
	    }

	    public void deleteById(Long id) {
	        facturaRepository.deleteById(id);
	    }

	    public Factura updateFactura(Long id, Factura factura) {
	        Optional<Factura> existingFactura = facturaRepository.findById(id);
	        if (existingFactura.isPresent()) {
	            Factura updatedFactura = existingFactura.get();

	            // Actualizar cliente
	            ClienteDTO cliente = clienteFactura.findById(factura.getClienteId());
	            if (cliente == null) {
	                throw new RuntimeException("El cliente con ID " + factura.getClienteId() + " no existe");
	            }

	            // Validar y actualizar productos
	            BigDecimal total = BigDecimal.ZERO;
	            for (Long productoId : factura.getListaproductos()) {
	                ProductoDTO producto = productoFactura.findById(productoId);
	                if (producto == null) {
	                    throw new RuntimeException("El producto con ID " + productoId + " no existe");
	                }
	                total = total.add(producto.getPrecio());
	            }

	            updatedFactura.setClienteId(factura.getClienteId());
	            updatedFactura.setListaproductos(factura.getListaproductos());
	            updatedFactura.setTotal(total);

	            return facturaRepository.save(updatedFactura);
	        } else {
	            throw new RuntimeException("La factura con ID " + id + " no existe");
	        }
	    }

		@Override
		public Optional<Factura> finById(Long id) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}	
	
}
