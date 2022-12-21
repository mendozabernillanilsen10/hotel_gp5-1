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
public class ServicioDTO {
    private int id;
    private boolean activo;
    private String createdAt;
    private String descripcion;
    private String nombre;
    private String updatedAt;
}
