package com.pc.gestion.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pc.gestion.cliente.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
