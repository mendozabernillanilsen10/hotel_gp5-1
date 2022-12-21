package com.hotel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Tarifa;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa,Integer> {
	List<Tarifa>findByNombreContaining(String nombre, Pageable page);
}
