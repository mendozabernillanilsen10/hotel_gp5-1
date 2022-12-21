package com.hotel.validators;
import com.hotel.entity.Persona;
import com.hotel.exceptions.ValidateServiceExceptions;

public class PersonaValidator {
	public static void save(Persona persona) {
		  if(persona.getNombre()==null || persona.getNombre().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("El nombre es requerido");
		  }
		  if(persona.getNombre().length()>100) {
			  throw new ValidateServiceExceptions("El nombre es muy largo(Maximo 100)");
		  }
		  if(persona.getApelllidos().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("ingrese apellidos");
		  }
		  if(persona.getApelllidos().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("ingrese apellidos");
		  }
		  if(persona.getDni().trim().isEmpty()) {
			  throw new ValidateServiceExceptions("ingrese DNI");
		  }	 
	  }
}
