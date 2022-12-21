package com.hotel.dtos;

import java.sql.Date;

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
public class PersonaDTO {
	private int id; 
	private String nombre; 
	private String apelllidos; 
	private String dni; 
	private Date Fecha; 
}
