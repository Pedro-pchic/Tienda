package com.pc.gestion.factura.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pc.gestion.factura.entity.Factura;
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
