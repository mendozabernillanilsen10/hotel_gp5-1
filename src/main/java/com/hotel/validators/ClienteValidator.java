package com.hotel.validators;

import com.hotel.entity.Cliente;
import com.hotel.exceptions.ValidateServiceExceptions;

public class ClienteValidator {
	public static void save(Cliente cliente) {
		 
		  if(cliente.getUltima_entrada().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("Ingrese Fecha de entrada");
		  }		 
	}
}
