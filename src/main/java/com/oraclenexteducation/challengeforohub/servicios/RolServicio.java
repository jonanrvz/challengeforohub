package com.oraclenexteducation.challengeforohub.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oraclenexteducation.challengeforohub.dto.roles.DatosRol;
import oraclenexteducation.challengeforohub.modelo.Rol;
import oraclenexteducation.challengeforohub.repositorio.RolRepositorio;

@Service
public class RolServicio {

	@Autowired
	private RolRepositorio rolRepositorio;

	public void crearRol(DatosRol datosRol) {
		String nombre = datosRol.nombre().toUpperCase();
		Optional<Rol> rol = rolRepositorio.findByNombre(nombre);

		if(rol.isPresent()) {
			throw new RuntimeException("Este nombre de rol ya existe");
		}

		Rol nuevoRol = new Rol();
		nuevoRol.setNombre(nombre);

		rolRepositorio.save(nuevoRol);
	}
}