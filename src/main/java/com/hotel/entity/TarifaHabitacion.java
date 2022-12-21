package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name="Tarifahabitacion")
@EntityListeners(AuditingEntityListener.class)
public class TarifaHabitacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ;
	@Column(name="precio",nullable=false,precision=6,scale=2)
	private double precio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="habitacionId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Habitacion habitacion; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tarifaId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Tarifa tarifa; 
}
