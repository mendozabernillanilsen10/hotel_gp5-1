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
@Table(name="habitacion")
@EntityListeners(AuditingEntityListener.class)
public class Habitacion {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ;
	
	@Column(unique=true,nullable=false,length=100)
	private String nombre ;
	
	@Column(name="descripcion",nullable=false,length=500)
	String descripcion;
	
	@Column(name="precio",nullable=false,precision=10,scale=2)
	private double precio;
	
	@Column(name="estado",nullable=false)
	private int estado;
	
	@Column(name="capacidad",nullable=false)
	private int capacidad;
	
	@Column(name="activo",nullable=false)
	private Boolean activo; 
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoriaId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Categoria categoria; 
	
}
