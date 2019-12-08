package com.tecsup.lab16.mascotasapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.lab16.mascotasapi.entities.Mascotas;
import com.tecsup.lab16.mascotasapi.repositories.MascotasRepository;

@Service
@Transactional
public class MascotasServiceImpl implements MascotasService{
	
	@Autowired
	private MascotasRepository mascotasRepository;
	
	@Override
	public List<Mascotas> findAll(){
		return mascotasRepository.findAll();
	}

	@Override
	public void save(Mascotas mascotas) {
		mascotasRepository.save(mascotas);
		
	}

	@Override
	public Mascotas findById(Long idmascotas) {
		return mascotasRepository.findById(idmascotas).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void deleteById(Long idmascotas) {
		mascotasRepository.deleteById(idmascotas);
		
	}

}
