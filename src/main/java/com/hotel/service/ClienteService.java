package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.Cliente;

public interface ClienteService {
	public List<Cliente> findAll(Pageable page); 
	  //public List<Cliente> finByNombre(String nombre,Pageable page); 
	  public Cliente findById(int id); 
	  public Cliente save(Cliente cliente); 
	  public void delete(int id); 
}
