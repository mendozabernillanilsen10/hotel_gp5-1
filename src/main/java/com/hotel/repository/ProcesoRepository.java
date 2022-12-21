package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Proceso;

@Repository
public interface ProcesoRepository extends JpaRepository<Proceso,Long>{


}
