package com.hotel.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.converters.UsuarioConverter;
import com.hotel.dtos.LoginRequestDTO;
import com.hotel.dtos.LoginResponseDTO;
import com.hotel.dtos.SignupRequestDTO;
import com.hotel.dtos.UsuarioDTO;
import com.hotel.entity.Usuario;
import com.hotel.service.UsuarioService;
import com.hotel.utils.WrapperResponse;

@RestController
@RequestMapping("/v1/")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	 
	private UsuarioConverter converter=new UsuarioConverter();
	
	@PostMapping(value="signup")
	public ResponseEntity<WrapperResponse<UsuarioDTO>> signup(@RequestBody SignupRequestDTO request){
		Usuario usuario=service.create(converter.signup(request));
		return new WrapperResponse<>(true,"success",converter.fromEntity(usuario)).createResponse(HttpStatus.CREATED);		
	}
	
	@PostMapping(value="login")
	public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request){
		LoginResponseDTO response=service.login(request);
		return new WrapperResponse<>(true,"success",response).createResponse(HttpStatus.OK);
	}
}
