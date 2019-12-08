package com.tecsup.lab16.mascotasapi.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tecsup.lab16.mascotasapi.entities.Mascotas;
import com.tecsup.lab16.mascotasapi.services.MascotasService;

@RestController
public class MascotasController {

private static final Logger logger= LoggerFactory.getLogger(HelloController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private MascotasService mascotasService;

	@GetMapping("/mascotas")
	public List<Mascotas> mascotas() {
		logger.info("call mascotas");
	
		List<Mascotas> mascotas = mascotasService.findAll();
		logger.info("mascotas: " + mascotas);
	
		return mascotas;
	}
	
	@PostMapping("/mascotas")	// https://spring.io/guides/gs/uploading-files/
	public Mascotas crear(@RequestParam(name="foto", required=false) MultipartFile foto, 
			@RequestParam("nombres") String nombres, 
			@RequestParam("raza") String raza, 
			@RequestParam("edad") String edad,
			@RequestParam("idusuarios") Long idusuarios) throws Exception {
		logger.info("call crear(" + nombres + ", " + raza + ", " + edad + ", " + foto + ", " + idusuarios + ")");
		
		Mascotas mascotas = new Mascotas();
		mascotas.setNombres(nombres);	
		mascotas.setRaza(raza);
		mascotas.setEdad(edad);
		mascotas.setIdusuarios(idusuarios);
		
		if (foto != null && !foto.isEmpty()) {
			String filename = System.currentTimeMillis() + foto.getOriginalFilename().substring(foto.getOriginalFilename().lastIndexOf("."));
			mascotas.setFoto(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(foto.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		mascotasService.save(mascotas);
		
		return mascotas;
	}
	
	@DeleteMapping("/mascotas/{idmascotas}")
	public ResponseEntity<String> eliminar(@PathVariable Long idmascotas) {
		logger.info("call eliminar: " + idmascotas);
		
		mascotasService.deleteById(idmascotas);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
	
	@GetMapping("/mascotas/{idmascotas}")
	public Mascotas obtener(@PathVariable Long idmascotas) {
		logger.info("call obtener: " + idmascotas);
		
		Mascotas mascotas = mascotasService.findById(idmascotas);
		
		return mascotas;
	}


}
