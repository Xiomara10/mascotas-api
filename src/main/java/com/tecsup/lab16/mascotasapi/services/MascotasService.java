package com.tecsup.lab16.mascotasapi.services;

import java.util.List;

import com.tecsup.lab16.mascotasapi.entities.Mascotas;

public interface MascotasService {
	
	public List<Mascotas> findAll();
	
	public Mascotas findById(Long id);

	public void save(Mascotas mascotas);
	
	public void deleteById(Long id);
	
}
