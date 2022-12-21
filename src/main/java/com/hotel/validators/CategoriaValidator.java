package com.hotel.validators;

import com.hotel.entity.Categoria;
import com.hotel.exceptions.ValidateServiceExceptions;

public class CategoriaValidator {
  public static void save(Categoria categoria) {
	  if(categoria.getNombre()==null || categoria.getNombre().trim().isEmpty()) {
		  throw new ValidateServiceExceptions("El nombre es requerido");
	  }
	  if(categoria.getNombre().length()>100) {
		  throw new ValidateServiceExceptions("El nombre es muy largo(Maximo 100)");
	  }
	 
  }
}
