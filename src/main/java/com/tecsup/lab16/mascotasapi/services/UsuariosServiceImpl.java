package com.tecsup.lab16.mascotasapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.lab16.mascotasapi.entities.Usuarios;
import com.tecsup.lab16.mascotasapi.repositories.UsuariosRepository;

@Service
@Transactional
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Override
	public Usuarios findByUsernameAndPassword(String nombres, String contraseña) {
		return usuarioRepository.findByUsernameAndPassword(nombres, contraseña);
	}

	@Override
	public Usuarios findByUsername(String nombres) {
		return usuarioRepository.findByUsername(nombres);
	}

	@Override
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuarioRepository.findAll();
	}

	@Override
	public Usuarios findById(Long idusuarios) {
		return usuarioRepository.findById(idusuarios).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Usuarios usuarios) {
		usuarioRepository.save(usuarios);
		
	}

	@Override
	public void deleteById(Long idusuarios) {
		usuarioRepository.deleteById(idusuarios);
		
	}
}
