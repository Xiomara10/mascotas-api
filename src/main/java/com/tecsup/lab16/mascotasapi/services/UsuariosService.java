package com.tecsup.lab16.mascotasapi.services;

import java.util.List;

import com.tecsup.lab16.mascotasapi.entities.Usuarios;

public interface UsuariosService {
Usuarios findByUsernameAndPassword(String nombres, String contraseña);
	
	Usuarios findByUsername(String nombres);
	
	public List<Usuarios> findAll();
	
	public Usuarios findById(Long idusuarios);
	
	public void save(Usuarios usuarios);
	
	public void deleteById(Long idusuarios);

}
