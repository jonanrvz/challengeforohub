package com.oraclenexteducation.challengeforohub.dto.respuestas;

import java.time.LocalDateTime;

import oraclenexteducation.challengeforohub.dto.usuarios.DatosResumidosUsuario;
import oraclenexteducation.challengeforohub.modelo.Respuesta;

public record DatosCompletosRespuesta(
		Long id, 
		String mensaje, 
		LocalDateTime fechaCreacion, 
		Boolean solucion, 
		Long publicacion_id,
		DatosResumidosUsuario autor) {

	public DatosCompletosRespuesta(Respuesta respuesta) {
		this(
				respuesta.getId(),
				respuesta.getMensaje(),
				respuesta.getFechaCreacion(),
				respuesta.getSolucion(),
				respuesta.getPublicacion().getId(),
				new DatosResumidosUsuario(respuesta.getAutor()));		
	}
}