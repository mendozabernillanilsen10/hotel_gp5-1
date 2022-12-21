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
@Table(name="trabajador")
@EntityListeners(AuditingEntityListener.class)
public class Trabajador {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="pago",nullable=false,precision=10,scale=2)
	private double pago; 
	
	@Column(name="fecha_entrada")
	private String fecha_entrada; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personaId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Persona persona;
	
	@Column(name="activo",nullable=false)
	private Boolean activo; 
}
