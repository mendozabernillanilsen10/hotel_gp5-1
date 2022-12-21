package com.hotel.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.entity.Categoria;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.CategoriaRepository;
import com.hotel.service.CategoriaService;
import com.hotel.validators.CategoriaValidator;

import lombok.extern.slf4j.Slf4j;

import com.hotel.exceptions.*;




@Service
@Slf4j 
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired 
    private CategoriaRepository repository; 
	
	@Override
	public List<Categoria> findAll(Pageable page) {
		try {
			 List<Categoria> categoria= repository.findAll(page).toList(); 
   	      return categoria;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public List<Categoria> finByNombre(String nombre, Pageable page) {
		try {
			List<Categoria> categoria= repository.findByNombreContaining(nombre, page);
		      return categoria;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public Categoria findById(int id) {
		try {
			Categoria existeRegistro= repository.findById(id)
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
	public Categoria save(Categoria habitacion) {
		try {
			CategoriaValidator.save(habitacion); 
			if(habitacion.getId()==0) {
				habitacion.setActivo(true);
				Categoria nuevoRegistro= repository.save(habitacion); 
				return nuevoRegistro;
			}
			Categoria existeRegistro= repository.findById(habitacion.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setNombre(habitacion.getNombre());
			existeRegistro.setImagen(habitacion.getImagen());
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
			Categoria existeRegistro= repository.findById(id)
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
