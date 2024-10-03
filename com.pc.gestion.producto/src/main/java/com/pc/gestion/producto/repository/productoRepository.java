package com.pc.gestion.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pc.gestion.producto.entity.Producto;
@Repository
public interface productoRepository extends JpaRepository<Producto, Long>{

}

