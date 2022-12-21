package com.hotel.validators;

import com.hotel.entity.DetalleServicio;
import com.hotel.entity.Proceso;
import com.hotel.exceptions.ValidateServiceExceptions;

public class ProcesoValidator {
	public static void save(Proceso proceso) {

		if(proceso.getTotal()<0) {
			throw new ValidateServiceExceptions("El total es incorrecto");
		}
	}
}
