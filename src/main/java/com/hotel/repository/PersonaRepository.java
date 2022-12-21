package com.hotel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{
	List<Persona>findByNombreContaining(String nombre, Pageable page);
}
