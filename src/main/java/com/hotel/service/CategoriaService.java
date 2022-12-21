package com.hotel.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.Categoria;


public interface CategoriaService {
   public List<Categoria> findAll(Pageable page); 
   public List<Categoria> finByNombre(String nombre,Pageable page); 
   public Categoria findById(int id); 
   public Categoria save(Categoria habitacion); 
   public void delete(int id); 
}
