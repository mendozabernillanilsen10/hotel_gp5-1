package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;


import com.hotel.entity.Tarifa;

public interface TarifaService {
	 public List<Tarifa> findAll(Pageable page); 
	   public List<Tarifa> finByNombre(String nombre,Pageable page); 
	   public Tarifa findById(int id); 
	   public Tarifa save(Tarifa tarifa); 
	   public void delete(int id); 
}
