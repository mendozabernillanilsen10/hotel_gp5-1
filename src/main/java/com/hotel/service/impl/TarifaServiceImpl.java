package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.hotel.entity.Tarifa;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.TarifaRepository;
import com.hotel.service.TarifaService;

import com.hotel.validators.TarifaValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class TarifaServiceImpl implements TarifaService{
	@Autowired 
	private TarifaRepository repository; 
	
	@Override
	public List<Tarifa> findAll(Pageable page) {
		try {
			 List<Tarifa> tarifa= repository.findAll(page).toList(); 
  	      return tarifa;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public List<Tarifa> finByNombre(String nombre, Pageable page) {
		try {
			List<Tarifa> tarifa= repository.findByNombreContaining(nombre, page);
		      return tarifa;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public Tarifa findById(int id) {
		try {
			Tarifa existeRegistro= repository.findById(id)
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
	public Tarifa save(Tarifa tarifa) {
		try {
			TarifaValidator.save(tarifa); 
			if(tarifa.getId()==0) {
				Tarifa nuevoRegistro= repository.save(tarifa); 
				return nuevoRegistro;
			}
			Tarifa existeRegistro= repository.findById(tarifa.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setNombre(tarifa.getNombre());
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
			Tarifa existeRegistro= repository.findById(id)
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
