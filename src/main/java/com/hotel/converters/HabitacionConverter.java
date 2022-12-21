package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.HabitacionDTO;
import com.hotel.entity.Categoria;
import com.hotel.entity.Habitacion;

@Component
public class HabitacionConverter extends AbstractConverter<Habitacion,HabitacionDTO> {

	@Override
	public HabitacionDTO fromEntity(Habitacion entity) {
		if(entity==null) return null; 
		return HabitacionDTO.builder()
				.id(entity.getId())
				.nombre(entity.getNombre())
				.descripcion(entity.getDescripcion())
				.precio(entity.getPrecio())
				.estado(entity.getEstado())
				.capacidad(entity.getCapacidad())
				.categoriaId(entity.getCategoria().getId())
				.categoriaNombre(entity.getCategoria().getNombre())
				.build(); 
				
	}

	@Override
	public Habitacion fromDTO(HabitacionDTO dto) {
		if(dto==null) return null; 
		Habitacion habitacion= new Habitacion();
		Categoria categoria= new Categoria(); 
		
		categoria.setId(dto.getCategoriaId());
		categoria.setNombre(dto.getCategoriaNombre());
		
		habitacion.setId(dto.getId());
		habitacion.setNombre(dto.getNombre());
		habitacion.setDescripcion(dto.getDescripcion());
		habitacion.setPrecio(dto.getPrecio());
		habitacion.setEstado(dto.getEstado());
		habitacion.setCapacidad(dto.getCapacidad());
		habitacion.setCategoria(categoria);
		return habitacion; 
	}

}
