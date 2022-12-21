package com.hotel.converters;

import com.hotel.dtos.TrabajadorDTO;
import com.hotel.entity.Persona;
import com.hotel.entity.Trabajador;

public class TrabajadorConverter extends AbstractConverter<Trabajador,TrabajadorDTO>{

	@Override
	public TrabajadorDTO fromEntity(Trabajador entity) {
		if(entity==null) return null; 
		return TrabajadorDTO.builder()
				.id(entity.getId())
				.pago(entity.getPago())
				.fecha_entrada(entity.getFecha_entrada())
				.personaId(entity.getPersona().getId())
				.nombreP(entity.getPersona().getNombre())
				.ApellidosP(entity.getPersona().getApelllidos())
				.dniP(entity.getPersona().getDni())
				.build(); 
	}

	@Override
	public Trabajador fromDTO(TrabajadorDTO dto) {
		if(dto==null) return null; 
		Trabajador trabajador= new Trabajador(); 
		Persona persona= new Persona(); 
		
		persona.setId(dto.getPersonaId());
		persona.setNombre(dto.getNombreP());
		persona.setApelllidos(dto.getApellidosP());
		persona.setDni(dto.getDniP());
		
		trabajador.setPago(dto.getPago());
		trabajador.setFecha_entrada(dto.getFecha_entrada());
		trabajador.setPersona(persona);
		return trabajador; 
		
	}

	

}
