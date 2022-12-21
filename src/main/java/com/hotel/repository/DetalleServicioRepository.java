package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.DetalleServicio;

@Repository
public interface DetalleServicioRepository extends JpaRepository<DetalleServicio,Long>{

}
