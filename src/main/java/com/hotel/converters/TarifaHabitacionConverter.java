package com.hotel.converters;

import org.springframework.stereotype.Component;

import com.hotel.dtos.TarifaHabitacionDTO;
import com.hotel.entity.Habitacion;
import com.hotel.entity.Tarifa;
import com.hotel.entity.TarifaHabitacion;


@Component
public class TarifaHabitacionConverter  extends AbstractConverter<TarifaHabitacion,TarifaHabitacionDTO>{

	@Override
	public TarifaHabitacionDTO fromEntity(TarifaHabitacion entity) {
		if(entity==null) return null; 
		return TarifaHabitacionDTO.builder()
				.id(entity.getId())
				.precio(entity.getPrecio())
				
				.habitacionId(entity.getHabitacion().getId())
				.nombreH(entity.getHabitacion().getNombre())
				.descripcionH(entity.getHabitacion().getDescripcion())
				.precioH(20)
				
				.tarifaId(entity.getTarifa().getId())
				.nombreT(entity.getTarifa().getNombre())
				.build();
	}

	@Override
	public TarifaHabitacion fromDTO(TarifaHabitacionDTO dto) {
		if(dto==null) return null;
		TarifaHabitacion tarifahabitacion= new TarifaHabitacion();   
		Habitacion habitacion= new Habitacion(); 
		Tarifa tarifa= new Tarifa();
		habitacion.setId(dto.getHabitacionId());
		habitacion.setNombre(dto.getNombreH());
		habitacion.setDescripcion(dto.getDescripcionH());
		habitacion.setPrecio(dto.getPrecioH());
		
		tarifa.setId(dto.getTarifaId());
		tarifa.setNombre(dto.getNombreT());
		
		tarifahabitacion.setPrecio(dto.getPrecio());
		
		tarifahabitacion.setHabitacion(habitacion);
		tarifahabitacion.setTarifa(tarifa);

		return tarifahabitacion; 
	}

}
