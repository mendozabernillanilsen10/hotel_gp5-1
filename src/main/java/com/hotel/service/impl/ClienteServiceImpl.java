package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hotel.entity.Cliente;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;
import com.hotel.repository.ClienteRepository;
import com.hotel.service.ClienteService;
import com.hotel.validators.ClienteValidator;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired 
	private ClienteRepository repository; 
	
	
	@Override
	public List<Cliente> findAll(Pageable page) {
	try {
		List<Cliente> cliente= repository.findAll(page).toList();
		return cliente; 
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
	public List<Cliente> finByNombre(String nombre, Pageable page) {
		try {
			List<Cliente> cliente= repository.findByNombreContaining(nombre, page);
		      return cliente;
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
	public Cliente findById(int id) {
		try {
			Cliente existeRegistro= repository.findById(id)
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
	public Cliente save(Cliente cliente) {
		try {
			ClienteValidator.save(cliente); 
			if(cliente.getId()==0) {
				cliente.setActivo(true);
				Cliente nuevoRegistro= repository.save(cliente); 
				return nuevoRegistro;
			}
			Cliente existeRegistro= repository.findById(cliente.getId())
					.orElseThrow(()->new NoDataFoundExceptions("No Existe el Registro"));
			existeRegistro.setUltima_entrada(cliente.getUltima_entrada());
			existeRegistro.setPersona(cliente.getPersona());
	
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
			Cliente existeRegistro= repository.findById(id)
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
