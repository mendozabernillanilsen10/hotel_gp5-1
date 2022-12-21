package com.hotel.converters;

import com.hotel.dtos.SignupRequestDTO;
import com.hotel.dtos.UsuarioDTO;
import com.hotel.entity.Usuario;

public class UsuarioConverter extends AbstractConverter<Usuario, UsuarioDTO>{

	@Override
	public UsuarioDTO fromEntity(Usuario entity) {
		if (entity==null) return null;
		return UsuarioDTO.builder()
				.id(entity.getId())
				.email(entity.getEmail())
				.activo(entity.getActivo())
				.build();
	}

	@Override
	public Usuario fromDTO(UsuarioDTO dto) {
		if (dto==null) return null;
		return Usuario.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.activo(dto.getActivo())
				.build();
	}
	public Usuario signup(SignupRequestDTO dto) {
		return Usuario.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.build();
	}

}
