package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.CategoriaDTO;
import com.hotel.entity.Categoria;

@Component
public class CategoriaConverter extends AbstractConverter<Categoria,CategoriaDTO>{

	@Override
	public CategoriaDTO fromEntity(Categoria entity) {
		if(entity==null) return null; 
		return CategoriaDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.imagen(entity.getImagen())
				.build(); 
	}

	@Override
	public Categoria fromDTO(CategoriaDTO dto) {
		if(dto==null) return null; 
		Categoria categoria= new Categoria(); 
		categoria.setId(dto.getId());	
		categoria.setNombre(dto.getNombre());
		categoria.setImagen(dto.getImagen());	
		return categoria; 
	}

}
