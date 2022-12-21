package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.TarifaHabitacion;

@Repository
public interface TarifaHabitacionRepository extends JpaRepository<TarifaHabitacion,Integer>{
	//List<TarifaHabitacion>findByNombreContaining(String nombre, Pageable page);
}
