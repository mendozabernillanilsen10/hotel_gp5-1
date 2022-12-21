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
public class ClienteDTO {
	 private int id;
	 private String ultima_entrada;
	 private int personaId;
	 private String nombreP; 
	 private String ApellidosP; 
	 private String dniP;
}
