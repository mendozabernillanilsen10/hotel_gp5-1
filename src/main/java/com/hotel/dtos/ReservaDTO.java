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
public class ReservaDTO {
    private int id;
    private boolean activo;
    private Date createdAt;
    private Date fechaReserva;
    private int habitacionId;
    private int personaId;
    private Date updatedAt;
}