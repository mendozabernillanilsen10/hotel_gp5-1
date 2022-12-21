package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;


import com.hotel.entity.Persona;

public interface PersonaService {
	public List<Persona> findAll(Pageable page); 
	   public List<Persona> finByNombre(String nombre,Pageable page); 
	   public Persona findById(int id); 
	   public Persona save(Persona perosna); 
	   public void delete(int id); 
}
