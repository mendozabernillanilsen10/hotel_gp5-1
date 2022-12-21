package com.hotel.dtos;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
	private int id ;
	private String nombre ;
	String descripcion;
	private double precio;
	private int estado;
	private int capacidad;
	private int categoriaId; 
	private String categoriaNombre; 
	
}
