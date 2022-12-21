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

import com.hotel.converters.TrabajadorConverter;

import com.hotel.dtos.TrabajadorDTO;

import com.hotel.entity.Trabajador;
import com.hotel.service.TrabajadorService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/trabajador")
public class TrabajadorController {
	
  @Autowired 
  private TrabajadorService service; 
  
  private TrabajadorConverter converter= new TrabajadorConverter(); 
  
  @GetMapping
  public ResponseEntity<List<TrabajadorDTO>>findAll(
		  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
		  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
		  ){
	       Pageable page= PageRequest.of(pageNumber, pageSize);
	      List<Trabajador>trabajador= service.findAll(page);
	       List<TrabajadorDTO> trabajadorDTO=converter.fromEntity(trabajador);
	       return new WrapperResponse(true,"SUCCESS",trabajadorDTO).createResponse(HttpStatus.OK);
	  
          }
  @GetMapping(value="/{id}")
  public ResponseEntity<WrapperResponse<TrabajadorDTO>> findById(@PathVariable("id")int id){
	  Trabajador trabajador= service.findById(id); 
	  TrabajadorDTO trabajadorDTO= converter.fromEntity(trabajador); 
	  return new WrapperResponse<TrabajadorDTO>(true,"SUCCESS",trabajadorDTO).createResponse(HttpStatus.OK);
  }
  @PostMapping()
  public ResponseEntity<TrabajadorDTO> create(@RequestBody TrabajadorDTO habitacionDTO){
	  Trabajador createTrabajador= service.save(converter.fromDTO(habitacionDTO)); 
	  TrabajadorDTO trabajadorReturn= converter.fromEntity(createTrabajador); 
	  return new WrapperResponse(true,"SUCCESS",trabajadorReturn).createResponse(HttpStatus.CREATED); 
  }
  @PutMapping(value = "/{id}")
  public ResponseEntity<TrabajadorDTO> update(@PathVariable("id")int id,@RequestBody TrabajadorDTO trabajadorDTO){ 
	  Trabajador updateTrabajador=service.save(converter.fromDTO(trabajadorDTO)); 
	  TrabajadorDTO trabajadorReturn=converter.fromEntity(updateTrabajador);
	  return new WrapperResponse(true,"SUCCESS",trabajadorReturn).createResponse(HttpStatus.OK); 
  }
  @DeleteMapping(value="/{id}")
  public ResponseEntity<?> delete(@PathVariable("id")int id){
	  service.delete(id);
	  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
  }
}
