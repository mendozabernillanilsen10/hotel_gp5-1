package com.hotel.entity;



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
@Table(name="DetalleServicio")
public class DetalleServicio {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="procesoId")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	public Proceso procesoId; 
	
	@Column(name="pago",nullable=false,precision=10,scale=2)
	private double pago; 
	
	@Column(name="subtotal",nullable=false,precision=8,scale=2)
	private Double subtotal;
	
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
		DetalleServicio other = (DetalleServicio) obj;
		return Objects.equals(id, other.id);
	}
	
}
