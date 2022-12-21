package com.hotel.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hotel.entity.Proceso;

public interface ProcesoService {
	public List<Proceso> findAll(Pageable page);
	public Proceso findById(Long id);
	public Proceso save(Proceso ingreso);
	public void anular(Long id);
}
