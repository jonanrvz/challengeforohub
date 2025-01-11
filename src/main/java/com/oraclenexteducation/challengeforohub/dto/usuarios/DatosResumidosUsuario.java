package com.oraclenexteducation.challengeforohub.dto.usuarios;

import oraclenexteducation.challengeforohub.modelo.Usuario;

public record DatosResumidosUsuario(
		Long usuarioId,
		String nombre,
		String correo) {

	public DatosResumidosUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNombre(), usuario.getCorreo());
	}
}