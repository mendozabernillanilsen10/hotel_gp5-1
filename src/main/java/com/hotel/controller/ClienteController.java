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

import com.hotel.converters.ClienteConverter;
import com.hotel.dtos.CategoriaDTO;
import com.hotel.dtos.ClienteDTO;
import com.hotel.entity.Cliente;
import com.hotel.service.ClienteService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
	@Autowired 
	private ClienteService service; 
	private ClienteConverter converter= new ClienteConverter();
	
	@GetMapping
	  public ResponseEntity<List<CategoriaDTO>>findAll(
			  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
			  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
			  ){
		       Pageable page= PageRequest.of(pageNumber, pageSize);
		       List<Cliente>cliente= service.findAll(page);
		       List<ClienteDTO> clienteDTO=converter.fromEntity(cliente);
		       return new WrapperResponse(true,"SUCCESS",clienteDTO).createResponse(HttpStatus.OK);
		  
	          }
	@GetMapping(value="/{id}")
	  public ResponseEntity<WrapperResponse<ClienteDTO>> findById(@PathVariable("id")int id){
		  Cliente cliente= service.findById(id); 
		  ClienteDTO clienteDTO= converter.fromEntity(cliente); 
		  return new WrapperResponse<ClienteDTO>(true,"SUCCESS",clienteDTO).createResponse(HttpStatus.OK);
	  }
	  @PostMapping()
	  public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO){
		  Cliente createCliente= service.save(converter.fromDTO(clienteDTO)); 
		  ClienteDTO clienteReturn= converter.fromEntity(createCliente); 
		  return new WrapperResponse(true,"SUCCESS",clienteReturn).createResponse(HttpStatus.CREATED); 
	  }
	  @PutMapping(value = "/{id}")
	  public ResponseEntity<ClienteDTO> update(@PathVariable("id")int id,@RequestBody ClienteDTO clienteDTO){ 
		  Cliente updateCliente=service.save(converter.fromDTO(clienteDTO)); 
		  ClienteDTO clienteReturn=converter.fromEntity(updateCliente);
		  return new WrapperResponse(true,"SUCCESS",clienteReturn).createResponse(HttpStatus.OK); 
	  }
	  @DeleteMapping(value="/{id}")
	  public ResponseEntity<?> delete(@PathVariable("id")int id){
		  service.delete(id);
		  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
	  }
}
