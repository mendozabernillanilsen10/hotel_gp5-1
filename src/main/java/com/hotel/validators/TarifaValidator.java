package com.hotel.validators;

import com.hotel.entity.Tarifa;
import com.hotel.exceptions.ValidateServiceExceptions;

public class TarifaValidator {
	 public static void save(Tarifa tarifa) {
		  if(tarifa.getNombre()==null || tarifa.getNombre().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("El nombre es requerido");
		  }
		  if(tarifa.getNombre().length()>100) {
			  throw new ValidateServiceExceptions("El nombre es muy largo(Maximo 100)");
		  }
		 
	  }
}
