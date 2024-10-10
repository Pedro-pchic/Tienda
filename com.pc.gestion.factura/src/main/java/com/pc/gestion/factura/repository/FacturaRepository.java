package com.pc.gestion.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pc.gestion.factura.entity.Factura;
@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
