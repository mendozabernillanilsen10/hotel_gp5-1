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

import com.hotel.converters.PersonaConverter;
import com.hotel.dtos.PersonaDTO;
import com.hotel.entity.Persona;
import com.hotel.service.PersonaService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/persona")
public class PersonaController {
	 @Autowired 
	 private PersonaService service; 
	 
	 private PersonaConverter converter= new PersonaConverter(); 
	 
	 @GetMapping
	  public ResponseEntity<List<PersonaDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<Persona>persona= service.findAll(page);
		       List<PersonaDTO> personaDTO=converter.fromEntity(persona);
		       return new WrapperResponse(true,"SUCCESS",personaDTO).createResponse(HttpStatus.OK);
		  
	          }
	 @GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<PersonaDTO>> findById(@PathVariable("id")int id){
		  Persona persona= service.findById(id); 
		  PersonaDTO personaDTO= converter.fromEntity(persona); 
		  return new WrapperResponse<PersonaDTO>(true,"SUCCESS",personaDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO personaDTO){
		  Persona createPersona= service.save(converter.fromDTO(personaDTO)); 
		  PersonaDTO personaReturn= converter.fromEntity(createPersona); 
		  return new WrapperResponse(true,"SUCCESS",personaReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<PersonaDTO> update(@PathVariable("id")int id,@RequestBody PersonaDTO personaDTO){ 
		  Persona updatePersona=service.save(converter.fromDTO(personaDTO)); 
		  PersonaDTO personaReturn=converter.fromEntity(updatePersona);
		  return new WrapperResponse(true,"SUCCESS",personaReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")int id){
		  service.delete(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }
}
