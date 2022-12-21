package com.hotel.validators;

import com.hotel.entity.TarifaHabitacion;
import com.hotel.exceptions.ValidateServiceExceptions;

public class TarifaHabitacionValidator {
	public static void save(TarifaHabitacion tarifahabitacion) {
		 if(tarifahabitacion.getPrecio()<0) {
			 throw new ValidateServiceExceptions("El Precio es incorreto");
		 }
		 
	}
}
