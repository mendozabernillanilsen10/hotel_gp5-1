package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.converters.HabitacionConverter;
import com.hotel.dtos.HabitacionDTO;

import com.hotel.entity.Habitacion;
import com.hotel.service.HabitacionService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/habitacion")
public class HabitacionController{
	
	@Autowired 
	  private HabitacionService service; 
	  
	  private HabitacionConverter converter=new HabitacionConverter();
	  
	  @GetMapping
	  public ResponseEntity<List<HabitacionDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<Habitacion>habitacion= service.findAll(page);
		       List<HabitacionDTO> habitacionDTO=converter.fromEntity(habitacion);
		       return new WrapperResponse(true,"SUCCESS",habitacionDTO).createResponse(HttpStatus.OK);
		  
	          }
	  @GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<HabitacionDTO>> findById(@PathVariable("id")int id){
		  Habitacion habitacion= service.findById(id); 
		  HabitacionDTO habitacionDTO= converter.fromEntity(habitacion); 
		  return new WrapperResponse<HabitacionDTO>(true,"SUCCESS",habitacionDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<HabitacionDTO> create(@RequestBody HabitacionDTO habitacionDTO){
		  Habitacion createHabitacion= service.save(converter.fromDTO(habitacionDTO)); 
		  HabitacionDTO habitacionReturn= converter.fromEntity(createHabitacion); 
		  return new WrapperResponse(true,"SUCCESS",habitacionReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<HabitacionDTO> update(@PathVariable("id")int id,@RequestBody HabitacionDTO habitacionDTO){ 
		  Habitacion updateHabitacion=service.save(converter.fromDTO(habitacionDTO)); 
		  HabitacionDTO habitacionReturn=converter.fromEntity(updateHabitacion);
		  return new WrapperResponse(true,"SUCCESS",habitacionReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")int id){
		  service.delete(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }
	
}
