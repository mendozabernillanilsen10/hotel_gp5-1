package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.hotel.entity.Habitacion;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.HabitacionRepository;
import com.hotel.service.HabitacionService;
import com.hotel.validators.HabitacionValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class HabitacionServiceImpl implements HabitacionService{
	@Autowired 
	private HabitacionRepository repository;

	@Override
	public List<Habitacion> findAll(Pageable page) {
		try {
			List<Habitacion> habitacion= repository.findAll(page).toList();
			return habitacion; 
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public List<Habitacion> finByNombre(String nombre, Pageable page) {
		try {
			List<Habitacion> habitacion= repository.findByNombreContaining(nombre, page);
		      return habitacion;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public Habitacion findById(int id) {
		try {
			Habitacion existeRegistro= repository.findById(id)
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
	public Habitacion save(Habitacion habitacion) {
		try {
			HabitacionValidator.save(habitacion); 
			if(habitacion.getId()==0) {
				habitacion.setActivo(true);
				Habitacion nuevoRegistro= repository.save(habitacion); 
				return nuevoRegistro;
			}
			Habitacion existeRegistro= repository.findById(habitacion.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setNombre(habitacion.getNombre());
			existeRegistro.setDescripcion(habitacion.getDescripcion());
			existeRegistro.setPrecio(habitacion.getPrecio());
			existeRegistro.setEstado(habitacion.getEstado());
			existeRegistro.setCapacidad(habitacion.getCapacidad());
			existeRegistro.setCategoria(habitacion.getCategoria());
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
			Habitacion existeRegistro= repository.findById(id)
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
