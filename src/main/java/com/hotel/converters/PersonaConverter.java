package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.PersonaDTO;
import com.hotel.entity.Persona;

@Component
public class PersonaConverter extends AbstractConverter<Persona,PersonaDTO>{

	@Override
	public PersonaDTO fromEntity(Persona entity) {
		if(entity==null) return null; 
		return PersonaDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.apelllidos(entity.getApelllidos())
				.dni(entity.getDni())
				.Fecha(entity.getFecha())
				.build(); 
	}

	@Override
	public Persona fromDTO(PersonaDTO dto) {
		if(dto==null) return null; 
		Persona persona= new Persona(); 
		persona.setId(dto.getId());
		persona.setNombre(dto.getNombre());
		persona.setApelllidos(dto.getApelllidos());
		persona.setDni(dto.getDni());
		persona.setFecha(dto.getFecha()); 
		return persona; 
	}

}
