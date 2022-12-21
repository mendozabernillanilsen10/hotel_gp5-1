package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.TarifaHabitacion;

public interface TarifaHabitacionService {
	public List<TarifaHabitacion> findAll(Pageable page); 
	//  public List<TarifaHabitacion> finByNombre(String nombre,Pageable page); 
	  public TarifaHabitacion findById(int id); 
	  public TarifaHabitacion save(TarifaHabitacion tarifahabitacion); 
	  public void delete(int id); 
}
