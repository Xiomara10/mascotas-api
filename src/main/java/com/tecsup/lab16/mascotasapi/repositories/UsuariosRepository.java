package com.tecsup.lab16.mascotasapi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tecsup.lab16.mascotasapi.entities.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.nombres=:nombres AND u.contraseña=:contraseña")
	Usuarios findByUsernameAndPassword(@Param("nombres") String nombres, @Param("contraseña") String contraseña);

	@Query("SELECT u FROM Usuario u WHERE u.nombres=:nombres")
	Usuarios findByUsername(@Param("nombres") String nombres);
}
