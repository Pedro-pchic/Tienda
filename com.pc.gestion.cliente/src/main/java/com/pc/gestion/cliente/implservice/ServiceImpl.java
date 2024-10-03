package com.pc.gestion.cliente.implservice;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pc.gestion.cliente.Iservice.IService;
import com.pc.gestion.cliente.entity.Cliente;
import com.pc.gestion.cliente.repository.ClienteRepository;
@Service
public class ServiceImpl implements IService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	//crear un nuevo Cliente
	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
	

	@Override
	public Cliente update(Long id, Cliente detallescliente) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
			Cliente clienteExistente = clienteOptional.get();
			clienteExistente.setNombre(detallescliente.getNombre());
			clienteExistente.setEmail(detallescliente.getEmail());
			clienteExistente.setTelefono(detallescliente.getTelefono());
			return clienteRepository.save(clienteExistente);
		}else {
			return null; 
		} 
	}

	@Override
	public void deleteById(Long id) {
		 clienteRepository.deleteById(id);
	}

}
