package com.hotel.dtos;



import java.util.Date;

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
public class ProcesoDTO {
    private Long id;
    private int cantidad; 
    private double total; 
    private String fecha_E;
    private String fecha_S;
    private String estado;
    private int tarifahabitacionId; 
    private double precioTH; 
    
    private String nombreH; 
    private String descripcionH; 
    //private Double precioH;
    
    private String nombreT; 
    
    private int clienteId;
    private String nombreC; 
    private String dniC; 
}