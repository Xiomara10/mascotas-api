package com.tecsup.lab16.mascotasapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tecsup.lab16.mascotasapi.entities.Mascotas;

public interface MascotasRepository extends CrudRepository<Mascotas, Long>{
	
	@Override
	List<Mascotas> findAll();
	
}
