package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
	//List<Cliente> findByNombreContaining(String nombre, Pageable page);
}
