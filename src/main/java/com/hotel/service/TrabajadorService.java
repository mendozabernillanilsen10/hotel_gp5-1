package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.Trabajador;

public interface TrabajadorService {
	 public List<Trabajador> findAll(Pageable page); 
	 // public List<Trabajador> finByNombre(String nombre,Pageable page); 
	  public Trabajador findById(int id); 
	  public Trabajador save(Trabajador trabajador); 
	  public void delete(int id); 

}
