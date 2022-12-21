package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.entity.Persona;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.PersonaRepository;
import com.hotel.service.PersonaService;

import com.hotel.validators.PersonaValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired 
	private PersonaRepository repository; 
	@Override
	public List<Persona> findAll(Pageable page) {
		try {
			 List<Persona> persona= repository.findAll(page).toList(); 
  	      return persona;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public List<Persona> finByNombre(String nombre, Pageable page) {
		try {
			List<Persona> persona= repository.findByNombreContaining(nombre, page);
		      return persona;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public Persona findById(int id) {
		try {
			Persona existeRegistro= repository.findById(id)
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
	public Persona save(Persona perosna) {
		try {
			PersonaValidator.save(perosna); 
			if(perosna.getId()==0) {
				perosna.setActivo(true);
				Persona nuevoRegistro= repository.save(perosna); 
				return nuevoRegistro;
			}
			Persona existeRegistro= repository.findById(perosna.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setNombre(perosna.getNombre());
			existeRegistro.setApelllidos(perosna.getApelllidos());
			existeRegistro.setDni(perosna.getDni());
			existeRegistro.setFecha(perosna.getFecha());
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
			Persona existeRegistro= repository.findById(id)
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
