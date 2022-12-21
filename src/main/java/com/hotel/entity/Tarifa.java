package com.hotel.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tarifa")
@EntityListeners(AuditingEntityListener.class)
public class Tarifa {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id; 
	@Column(unique=true,nullable=false,length=100)
	private String nombre ; 
}
