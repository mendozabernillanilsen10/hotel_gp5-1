package com.hotel.validators;

import com.hotel.entity.Usuario;
import com.hotel.exceptions.ValidateServiceExceptions;

public class UsuarioValidator {
	public static void save(Usuario usuario) {
		if(usuario.getEmail()==null || usuario.getEmail().trim().isEmpty()) {
			throw new ValidateServiceExceptions("El email es requerido");
		}
		if(usuario.getPassword()==null || usuario.getPassword().trim().isEmpty()) {
			throw new ValidateServiceExceptions("El password es requerido");
		}
	}
}
