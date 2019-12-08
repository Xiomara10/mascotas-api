package com.tecsup.lab16.mascotasapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tecsup.lab16.mascotasapi.entities.Usuarios;
import com.tecsup.lab16.mascotasapi.services.UsuariosService;

@RestController
@RequestMapping("/auth")
public class UsuariosController {
	
	@Autowired
    private UsuariosService usuariosService;
	
	@GetMapping("/usuarios")
	public List<Usuarios> usuarios() {
		logger.info("call usuarios");
		
		List<Usuarios> usuarios = usuariosService.findAll();
		logger.info("usuarios: " + usuarios);
		
		return usuarios;
	}
	
	
	@PostMapping("/usuarios")
	public Usuarios crear( @RequestParam("nombres") String nombres,@RequestParam("correo") String correo,@RequestParam("contraseña") String contraseña) throws Exception {
		logger.info("call crear(" + nombres + ", " + correo + ", " + contraseña + ")");
		
		Usuarios usuario = new Usuarios();
		usuario.setNombres(nombres);
		usuario.setCorreo(correo);
		usuario.setContraseña(contraseña);		
		usuariosService.save(usuario);
		return usuario;
	}
	
	@DeleteMapping("/usuarios/{idusuarios}")
	public ResponseEntity<String> eliminar(@PathVariable Long idusuarios) {
		logger.info("call eliminar: " + idusuarios);
		
		usuariosService.deleteById(idusuarios);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
	
	@GetMapping("/usuarios/{idusuarios}")
	public Usuarios obtener(@PathVariable Long idusuarios) {
		logger.info("call obtener: " + idusuarios);
		
		Usuarios usuarios = usuariosService.findById(idusuarios);
		
		return usuarios;
	}
	

		private static final Logger logger = LoggerFactory.getLogger(UsuariosController.class);
		
		
		@PostMapping("login")
		public Usuarios login(@RequestParam String nombres, @RequestParam String contraseña) throws Exception{
			logger.info("login("+nombres+", "+contraseña+")");
			
			Usuarios usuario = usuariosService.findByUsernameAndPassword(nombres, contraseña);
			logger.info("Login success: " + usuario);
			
			if(usuario == null)
				throw new Exception("Usuario y/o clave invalido");
			return usuario;
		}
}
