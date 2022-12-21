package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.TarifaDTO;
import com.hotel.entity.Tarifa;

@Component
public class TarifaConverter extends AbstractConverter<Tarifa,TarifaDTO> {

	@Override
	public TarifaDTO fromEntity(Tarifa entity) {
		if(entity==null) return null; 
		return TarifaDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.build();			
	}

	@Override
	public Tarifa fromDTO(TarifaDTO dto) {
		if(dto==null) return null; 
		Tarifa tarifa= new Tarifa(); 
		tarifa.setId(dto.getId());
		tarifa.setNombre(dto.getNombre());
		return tarifa;
	}

}
