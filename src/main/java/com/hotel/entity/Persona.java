package com.hotel.entity;


import java.sql.Date;


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
@Table(name="persona")
@EntityListeners(AuditingEntityListener.class)
public class Persona {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id; 
	
	@Column(unique=true,nullable=false,length=100)
	private String nombre;
	
	@Column(unique=true,nullable=false)
	private String apelllidos;
	
	@Column(name="dni",nullable=false)
	private String dni;
	
	@Column(name="fecha", nullable=false, updatable=false)
	private Date fecha;
	
	@Column(name="activo",nullable=false)
	private Boolean activo; 
	

	
	
}
