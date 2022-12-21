package com.hotel.converters;


import com.hotel.dtos.ProcesoDTO;
import com.hotel.entity.Cliente;
import com.hotel.entity.Habitacion;
import com.hotel.entity.Persona;
import com.hotel.entity.Proceso;
import com.hotel.entity.Tarifa;
import com.hotel.entity.TarifaHabitacion;

public class ProcesoConverter extends AbstractConverter<Proceso,ProcesoDTO>{

	@Override
	public ProcesoDTO fromEntity(Proceso entity) {
		if(entity==null) return null; 
		return ProcesoDTO.builder()
				.id(entity.getId())
				.cantidad(entity.getCantidad())
				.total(entity.getTotal())
				.fecha_E(entity.getFecha_E())
				.fecha_S(entity.getFecha_S())
				.estado(entity.getEstado())
				
				.tarifahabitacionId(entity.getTarifaHabitacionId().getId())
				.precioTH(entity.getTarifaHabitacionId().getPrecio())
				
				.nombreH(entity.getTarifaHabitacionId().getHabitacion().getNombre())
				.descripcionH(entity.getTarifaHabitacionId().getHabitacion().getDescripcion())
				//.precioH(entity.getTotal())
				
				.nombreT(entity.getTarifaHabitacionId().getTarifa().getNombre())
				
				.clienteId(entity.getClienteId().getId())
				.nombreC(entity.getClienteId().getPersona().getNombre())
				.dniC(entity.getClienteId().getPersona().getDni())
				.build();				
	}

	@Override
	public Proceso fromDTO(ProcesoDTO dto) {
		if(dto==null) return null; 
		
		Proceso proceso=new Proceso(); 
		TarifaHabitacion tarifaH= new TarifaHabitacion(); 
		Habitacion habitacion= new Habitacion(); 
		Tarifa tarifa=new Tarifa(); 
		Cliente cliente= new Cliente();
		Persona persona=new Persona(); 
		tarifaH.setId(dto.getTarifahabitacionId());
		tarifaH.setPrecio(dto.getPrecioTH());
		//
		habitacion.setNombre(dto.getNombreH());
		habitacion.setDescripcion(dto.getDescripcionH()); 
		//
		tarifa.setNombre(dto.getNombreT());
		
		cliente.setId(dto.getClienteId());
		persona.setNombre(dto.getNombreC());
		persona.setDni(dto.getDniC());
		//
		proceso.setCantidad(dto.getCantidad());
		proceso.setTotal(dto.getTotal());
		proceso.setFecha_E(dto.getFecha_E());
		proceso.setFecha_S(dto.getFecha_S());
		proceso.setEstado(dto.getEstado());
		// 
		proceso.setClienteId(cliente);
		
		proceso.setTarifaHabitacionId(tarifaH);
		
		tarifaH.setTarifa(tarifa);	
		tarifaH.setHabitacion(habitacion);	
		cliente.setPersona(persona);
		
		return proceso; 
	}

}
