package com.tecsup.lab16.mascotasapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascotas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmascotas;
	
	private String nombres;
	
	private String raza;
	
	private String edad;
	
	private String foto;
	
	private Long idusuarios;

	public Long getIdmascotas() {
		return idmascotas;
	}

	public void setIdmascotas(Long idmascotas) {
		this.idmascotas = idmascotas;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	@Override
	public String toString() {
		return "Mascotas [idmascotas=" + idmascotas + ", nombres=" + nombres + ", raza=" + raza + ", edad=" + edad
				+ ", foto=" + foto + ", idusuarios=" + idusuarios +"]";
	}
	
	
}
