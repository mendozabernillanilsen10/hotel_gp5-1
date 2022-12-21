package com.hotel.validators;


import com.hotel.entity.Habitacion;
import com.hotel.exceptions.ValidateServiceExceptions;

public class HabitacionValidator {
	public static void save(Habitacion habitacion) {
		 if(habitacion.getNombre()==null || habitacion.getNombre().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("El nombre es requerido");
		  }
		  if(habitacion.getNombre().length()>100) {
			  throw new ValidateServiceExceptions("El nombre es muy largo(Maximo 100)");
		  }
		  if(habitacion.getDescripcion()==null || habitacion.getDescripcion().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("El nombre es requerido");
		  }
		  if(habitacion.getDescripcion().length()>500) {
			  throw new ValidateServiceExceptions("El nombre es muy largo(Maximo 500)");
		  }
		  if(habitacion.getPrecio()<0) {
			  throw new ValidateServiceExceptions("El Precio es incorreto");
		  }
		  if(habitacion.getEstado()<0) {
			  throw new ValidateServiceExceptions("El Estado es incorreto");
		  }
		  if(habitacion.getCapacidad()<0) {
			  throw new ValidateServiceExceptions("La Capacidad es incorreto");
		  }
		 
	}
}
