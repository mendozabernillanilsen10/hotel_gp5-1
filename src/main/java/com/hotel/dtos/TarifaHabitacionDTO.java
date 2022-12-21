package com.hotel.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarifaHabitacionDTO {
    private int id;
    private double precio;
    private int habitacionId;
    private String nombreH; 
    private String descripcionH; 
    private double precioH; 
    private int tarifaId;
    private String nombreT; 
}