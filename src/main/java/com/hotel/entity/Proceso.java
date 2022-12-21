package com.hotel.entity;

import java.sql.Date;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="proceso")
public class Proceso {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long  id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tarifaHabitacionId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public TarifaHabitacion tarifaHabitacionId; 	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="clienteId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Cliente clienteId; 
	
	//@OneToMany(mappedBy="detalleservicio", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	//private List<DetalleServicio> detalles;
	
	@Column(name="cantidad",nullable=false)
	private int cantidad;  
	
	@Column(name="total",nullable=false,precision=10,scale=2)
	private double total; 
	
	@Column(name="fecha_E", nullable=false)
	private String fecha_E;
	
	@Column(name="fecha_S", nullable=false)
	private String fecha_S;
	
	@Column(length = 20, nullable=false)
	private String estado;
	
	@Column(name="activo",nullable=false)
	private Boolean activo; 
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proceso other = (Proceso) obj;
		if(id==null) {
			if(other.id != null);
				return false;
		}else if (!id.equals(other.id)){
			return false;
		}
		return true;
	}
	
}
