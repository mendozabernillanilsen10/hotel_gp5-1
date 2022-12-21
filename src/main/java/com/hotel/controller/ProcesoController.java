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


import com.hotel.converters.ProcesoConverter;

import com.hotel.dtos.ProcesoDTO;

import com.hotel.entity.Proceso;

import com.hotel.service.ProcesoService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/proceso")
public class ProcesoController {
	@Autowired 
	 private ProcesoService service; 
	  
	  private ProcesoConverter converter=new ProcesoConverter();
	  
	  @GetMapping
	  public ResponseEntity<List<ProcesoDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<Proceso>habitacion= service.findAll(page);
		       List<ProcesoDTO> habitacionDTO=converter.fromEntity(habitacion);
		       return new WrapperResponse(true,"SUCCESS",habitacionDTO).createResponse(HttpStatus.OK);
		  
	          }
	  @GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<ProcesoDTO>> findById(@PathVariable("id")Long id){
		  Proceso proceso= service.findById(id); 
		  ProcesoDTO procesoDTO= converter.fromEntity(proceso); 
		  return new WrapperResponse<ProcesoDTO>(true,"SUCCESS",procesoDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<ProcesoDTO> create(@RequestBody ProcesoDTO procesoDTO){
		  Proceso createProceso= service.save(converter.fromDTO(procesoDTO)); 
		  ProcesoDTO procesoReturn= converter.fromEntity(createProceso); 
		  return new WrapperResponse(true,"SUCCESS",procesoReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<ProcesoDTO> update(@PathVariable("id")Long id,@RequestBody ProcesoDTO procesoDTO){ 
		 Proceso updateProceso=service.save(converter.fromDTO(procesoDTO)); 
		  ProcesoDTO procesoReturn=converter.fromEntity(updateProceso);
		  return new WrapperResponse(true,"SUCCESS",procesoReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")Long id){
		  service.anular(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }
}
