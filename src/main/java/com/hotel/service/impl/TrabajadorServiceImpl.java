package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.entity.Trabajador;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.TrabajadorRepository;
import com.hotel.service.TrabajadorService;
import com.hotel.validators.TrabajadorValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class TrabajadorServiceImpl implements TrabajadorService{
	@Autowired
	private TrabajadorRepository repository; 
	
	@Override
	public List<Trabajador> findAll(Pageable page) {
		try {
			List<Trabajador> trabajador= repository.findAll(page).toList();
			return trabajador; 
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
	public List<Trabajador> finByNombre(String nombre, Pageable page) {
		try {
			List<Trabajador> trabajador= repository.findByNombreContaining(nombre, page);
		      return trabajador;
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
	public Trabajador findById(int id) {
		try {
			Trabajador existeRegistro= repository.findById(id)
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
	public Trabajador save(Trabajador trabajador) {
		try {
			TrabajadorValidator.save(trabajador); 
			if(trabajador.getId()==0) {
				trabajador.setActivo(true);
				Trabajador nuevoRegistro= repository.save(trabajador); 
				return nuevoRegistro;
			}
			Trabajador existeRegistro= repository.findById(trabajador.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setPago(trabajador.getPago());
			existeRegistro.setFecha_entrada(trabajador.getFecha_entrada());
			existeRegistro.setPersona(trabajador.getPersona());
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
			Trabajador existeRegistro= repository.findById(id)
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
