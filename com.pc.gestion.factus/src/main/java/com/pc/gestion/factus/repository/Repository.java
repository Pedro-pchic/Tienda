package com.pc.gestion.factus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pc.gestion.factus.entity.Factura;

public interface Repository<Factura> extends JpaRepository<Factura, Long>{

}
