package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.hotel.entity.Proceso;
import com.hotel.exceptions.GeneralServiceExceptions;
import com.hotel.exceptions.NoDataFoundExceptions;
import com.hotel.exceptions.ValidateServiceExceptions;

import com.hotel.repository.ProcesoRepository;
import com.hotel.service.ProcesoService;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class ProcesoServiceImpl implements ProcesoService{
	
	@Autowired 
	private ProcesoRepository repository;
	//@Autowired 
    //private DetalleServicioRepository detallerepository; 
	@Override
	public List<Proceso> findAll(Pageable page) {
		try {
			List<Proceso> proceso = repository.findAll(page).toList();
			return proceso;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	

	@Override
	public Proceso findById(Long id) {
		try {
			Proceso existRegistro = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundExceptions("No existe el registro"));
			return existRegistro;
		}catch(ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(),e);
			throw e;
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(),e);
		}
	}

	@Override
	public Proceso save(Proceso ingreso) {
		try {			
			//ingreso.getDetalles().forEach(detalle-> detalle.setProcesoId(ingreso));
			//ProcesoValidator.save(ingreso);
			
			if(ingreso.getId() == null) {	
				ingreso.setEstado("Aceptado");
				ingreso.setActivo(true);
				//ingreso.setFecha_E(null);
				Proceso newRegistro = repository.save(ingreso);
				return newRegistro;
			}
			
			Proceso existRegistro = repository.findById(ingreso.getId())
					.orElseThrow(() -> new NoDataFoundExceptions("No existe el registro"));
			
			//existRegistro.setDetalles(ingreso.getDetalles());
			existRegistro.setTotal(ingreso.getTotal());
			existRegistro.setEstado("Modificado");
			existRegistro.setCantidad(ingreso.getCantidad());
			existRegistro.setFecha_E(ingreso.getFecha_E());
			existRegistro.setFecha_S(ingreso.getFecha_S());
			
			//List<DetalleServicio> deletedDetalles=existRegistro.getDetalles();
		//	deletedDetalles.removeAll(ingreso.getDetalles());
			//detallerepository.deleteAll(deletedDetalles);
			repository.save(existRegistro);
			return existRegistro;
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	}

	@Override
	public void anular(Long id) {
		try {
			Proceso ingreso = repository.findById(id)
					.orElseThrow(() -> new NoDataFoundExceptions("No existe el registro."));
			ingreso.setEstado("Anulado");
			repository.save(ingreso);
		} catch (ValidateServiceExceptions | NoDataFoundExceptions e) {
			log.info(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GeneralServiceExceptions(e.getMessage(), e);
		}
	} 
	

}
