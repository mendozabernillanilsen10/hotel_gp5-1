package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.ClienteDTO;
import com.hotel.entity.Cliente;
import com.hotel.entity.Persona;

@Component
public class ClienteConverter extends AbstractConverter<Cliente,ClienteDTO>{

	@Override
	public ClienteDTO fromEntity(Cliente entity) {
		if(entity==null) return null; 
		return ClienteDTO.builder() 
		.id(entity.getId())
		.ultima_entrada(entity.getUltima_entrada())
		.personaId(entity.getPersona().getId())
		.nombreP(entity.getPersona().getNombre())
		.ApellidosP(entity.getPersona().getApelllidos())
		.dniP(entity.getPersona().getDni())
		.build();
	}

	@Override
	public Cliente fromDTO(ClienteDTO dto) {
		if(dto==null) return null; 
		Cliente cliente=new Cliente();
		Persona persona= new Persona(); 
		persona.setId(dto.getPersonaId());
		persona.setNombre(dto.getNombreP());
		persona.setApelllidos(dto.getApellidosP());
		persona.setDni(dto.getDniP());
		
	    cliente.setId(dto.getId());
	    cliente.setUltima_entrada(dto.getUltima_entrada());
	    cliente.setPersona(persona);
		return cliente; 
	}

}
