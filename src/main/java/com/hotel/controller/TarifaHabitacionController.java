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

import com.hotel.converters.TarifaHabitacionConverter;
import com.hotel.dtos.HabitacionDTO;
import com.hotel.dtos.TarifaHabitacionDTO;
import com.hotel.entity.Habitacion;
import com.hotel.entity.TarifaHabitacion;
import com.hotel.service.TarifaHabitacionService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/tarifaHabitacion")
public class TarifaHabitacionController {
	
	@Autowired 
    private TarifaHabitacionService service; 
    private TarifaHabitacionConverter converter= new TarifaHabitacionConverter();
    
    @GetMapping
	  public ResponseEntity<List<TarifaHabitacionDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<TarifaHabitacion>tarifahabitacion= service.findAll(page);
		       List<TarifaHabitacionDTO> tarifahabitacionDTO=converter.fromEntity(tarifahabitacion);
		       return new WrapperResponse(true,"SUCCESS",tarifahabitacionDTO).createResponse(HttpStatus.OK);
		  
	          }
	  @GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<TarifaHabitacionDTO>> findById(@PathVariable("id")int id){
		  TarifaHabitacion tarifahabitacion= service.findById(id); 
		  TarifaHabitacionDTO tarifahabitacionDTO= converter.fromEntity(tarifahabitacion); 
		  return new WrapperResponse<TarifaHabitacionDTO>(true,"SUCCESS",tarifahabitacionDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<TarifaHabitacionDTO> create(@RequestBody TarifaHabitacionDTO tarifahabitacionDTO){
		  TarifaHabitacion createTarifaHabitacion= service.save(converter.fromDTO(tarifahabitacionDTO)); 
		  TarifaHabitacionDTO tarifahabitacionReturn= converter.fromEntity(createTarifaHabitacion); 
		  return new WrapperResponse(true,"SUCCESS",tarifahabitacionReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<TarifaHabitacionDTO> update(@PathVariable("id")int id,@RequestBody TarifaHabitacionDTO tarifahabitacionDTO){ 
		  TarifaHabitacion updateTarifaHabitacion=service.save(converter.fromDTO(tarifahabitacionDTO)); 
		  TarifaHabitacionDTO tarifahabitacionReturn=converter.fromEntity(updateTarifaHabitacion);
		  return new WrapperResponse(true,"SUCCESS",tarifahabitacionReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")int id){
		  service.delete(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }
    
}
