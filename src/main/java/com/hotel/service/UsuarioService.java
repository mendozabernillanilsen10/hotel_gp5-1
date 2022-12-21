package com.hotel.service;

import com.hotel.dtos.LoginRequestDTO;
import com.hotel.dtos.LoginResponseDTO;
import com.hotel.entity.Usuario;

public interface UsuarioService {
	public Usuario create(Usuario usuario);
	public LoginResponseDTO login(LoginRequestDTO request);
	public String createToken(Usuario usuario) ;
	public boolean validateToken(String token);
	public String getUserFromToken(String jwt);
}
