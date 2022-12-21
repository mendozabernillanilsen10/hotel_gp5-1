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
public class TrabajadorDTO {
	private int id ;
	private double pago; 
	private String fecha_entrada; 
	private int personaId; 
	private String nombreP; 
	private String ApellidosP; 
	private String dniP;
}
