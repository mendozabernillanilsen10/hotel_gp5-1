package com.hotel.validators;


import com.hotel.entity.Trabajador;
import com.hotel.exceptions.ValidateServiceExceptions;

public class TrabajadorValidator {
	public static void save(Trabajador trabajador) {
		
		if(trabajador.getPago()<0) {
			  throw new ValidateServiceExceptions("El Pago es incorreto");
		 }
		if(trabajador.getFecha_entrada().trim().isEmpty()) {
			throw new ValidateServiceExceptions("Agrega fecha de entrada");
		}
		 
	}
}
