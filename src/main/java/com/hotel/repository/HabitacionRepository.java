package com.hotel.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Habitacion;
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion,Integer>{
  List<Habitacion> findByNombreContaining(String nombre, Pageable page);
}
