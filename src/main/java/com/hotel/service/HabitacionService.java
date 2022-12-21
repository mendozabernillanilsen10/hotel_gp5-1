package com.hotel.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.Habitacion;

public interface HabitacionService {
	  public List<Habitacion> findAll(Pageable page); 
	  public List<Habitacion> finByNombre(String nombre,Pageable page); 
	  public Habitacion findById(int id); 
	  public Habitacion save(Habitacion habitacion); 
	  public void delete(int id); 
}
