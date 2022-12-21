package com.hotel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer>{
	//List<Trabajador>findByNombreContaining(String nombre, Pageable page);
}
