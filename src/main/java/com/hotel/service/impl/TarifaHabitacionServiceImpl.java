package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.hotel.entity.TarifaHabitacion;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;

import com.hotel.repository.TarifaHabitacionRepository;

import com.hotel.service.TarifaHabitacionService;

import com.hotel.validators.TarifaHabitacionValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class TarifaHabitacionServiceImpl implements TarifaHabitacionService{
	
	@Autowired 
	private TarifaHabitacionRepository repository;
	@Override
	public List<TarifaHabitacion> findAll(Pageable page) {
		try {
			List<TarifaHabitacion> tarifahabitacion= repository.findAll(page).toList();
			return tarifahabitacion; 
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}
/*
	@Override
	public List<TarifaHabitacion> finByNombre(String nombre, Pageable page) {
		try {
			List<TarifaHabitacion> tarifahabitacion= repository.findByNombreContaining(nombre, page);
		      return tarifahabitacion;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}
*/
	@Override
	public TarifaHabitacion findById(int id) {
		try {
			TarifaHabitacion existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro")); 
			return existeRegistro;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public TarifaHabitacion save(TarifaHabitacion tarifahabitacion) {
		try {
			TarifaHabitacionValidator.save(tarifahabitacion); 
			if(tarifahabitacion.getId()==0) {
				TarifaHabitacion nuevoRegistro= repository.save(tarifahabitacion); 
				return nuevoRegistro;
			}
			TarifaHabitacion existeRegistro= repository.findById(tarifahabitacion.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setPrecio(tarifahabitacion.getPrecio()); 
			existeRegistro.setHabitacion(tarifahabitacion.getHabitacion());
			existeRegistro.setTarifa(tarifahabitacion.getTarifa());		
			repository.save(existeRegistro); 
			return existeRegistro;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public void delete(int id) {
		try {
			TarifaHabitacion existeRegistro= repository.findById(id)
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			repository.delete(existeRegistro);
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
		
	}

}
