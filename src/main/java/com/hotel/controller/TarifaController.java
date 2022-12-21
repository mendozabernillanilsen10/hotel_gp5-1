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

import com.hotel.converters.TarifaConverter;

import com.hotel.dtos.TarifaDTO;

import com.hotel.entity.Tarifa;
import com.hotel.service.TarifaService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/tarifa")
public class TarifaController {
	  @Autowired 
	  private TarifaService service; 
	  
	  private TarifaConverter converter= new TarifaConverter(); 
	  
	  @GetMapping
	  public ResponseEntity<List<TarifaDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<Tarifa>tarifa= service.findAll(page);
		       List<TarifaDTO> tarifaDTO=converter.fromEntity(tarifa);
		       return new WrapperResponse(true,"SUCCESS",tarifaDTO).createResponse(HttpStatus.OK);
		  
	          }
	  @GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<TarifaDTO>> findById(@PathVariable("id")int id){
		  Tarifa tarifa= service.findById(id); 
		  TarifaDTO tarifaDTO= converter.fromEntity(tarifa); 
		  return new WrapperResponse<TarifaDTO>(true,"SUCCESS",tarifaDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<TarifaDTO> create(@RequestBody TarifaDTO tarifaDTO){
		  Tarifa createTarifa= service.save(converter.fromDTO(tarifaDTO)); 
		  TarifaDTO categoriaReturn= converter.fromEntity(createTarifa); 
		  return new WrapperResponse(true,"SUCCESS",categoriaReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<TarifaDTO> update(@PathVariable("id")int id,@RequestBody TarifaDTO tarifaDTO){ 
		  Tarifa updateTarifa=service.save(converter.fromDTO(tarifaDTO)); 
		  TarifaDTO tarifaReturn=converter.fromEntity(updateTarifa);
		  return new WrapperResponse(true,"SUCCESS",tarifaReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")int id){
		  service.delete(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }

}
