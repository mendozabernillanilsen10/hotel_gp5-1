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

import com.hotel.converters.CategoriaConverter;
import com.hotel.dtos.CategoriaDTO;
import com.hotel.entity.Categoria;
import com.hotel.service.CategoriaService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/categoria")

public class CategoriaController {
	
  @Autowired 
  private CategoriaService service; 
  
  private CategoriaConverter converter=new CategoriaConverter();
  
  @GetMapping
  public ResponseEntity<List<CategoriaDTO>>findAll(
		  @RequestParam(value="offset",required=false,defaultValue="0")int pageNumber,
		  @RequestParam(value="limit",required=false,defaultValue="5")int pageSize
		  ){
	       Pageable page= PageRequest.of(pageNumber, pageSize);
	       List<Categoria>categorias= service.findAll(page);
	       List<CategoriaDTO> categoriasDTO=converter.fromEntity(categorias);
	       return new WrapperResponse(true,"SUCCESS",categoriasDTO).createResponse(HttpStatus.OK);
	  
          }
  @GetMapping(value="/{id}")
  public ResponseEntity<WrapperResponse<CategoriaDTO>> findById(@PathVariable("id")int id){
	  Categoria categoria= service.findById(id); 
	  CategoriaDTO categoriasDTO= converter.fromEntity(categoria); 
	  return new WrapperResponse<CategoriaDTO>(true,"SUCCESS",categoriasDTO).createResponse(HttpStatus.OK);
  }
  @PostMapping()
  public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriasDTO){
	  Categoria createCategoria= service.save(converter.fromDTO(categoriasDTO)); 
	  CategoriaDTO categoriaReturn= converter.fromEntity(createCategoria); 
	  return new WrapperResponse(true,"SUCCESS",categoriaReturn).createResponse(HttpStatus.CREATED); 
  }
  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> update(@PathVariable("id")int id,@RequestBody CategoriaDTO categoriasDTO){ 
	  Categoria updateCategoria=service.save(converter.fromDTO(categoriasDTO)); 
	  CategoriaDTO categoriaReturn=converter.fromEntity(updateCategoria);
	  return new WrapperResponse(true,"SUCCESS",categoriaReturn).createResponse(HttpStatus.OK); 
  }
  @DeleteMapping(value="/{id}")
  public ResponseEntity<?> delete(@PathVariable("id")int id){
	  service.delete(id);
	  return new WrapperResponse(true,"SUCCESS",null).createResponse(HttpStatus.OK);
  }
}
