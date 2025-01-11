package com.oraclenexteducation.challengeforohub.dto.respuestas;

import java.time.LocalDateTime;

import oraclenexteducation.challengeforohub.modelo.Respuesta;

public record DatosResumidosRespuesta(Long id, String mensaje, LocalDateTime fechaCreacion, Boolean solucion) {

	public DatosResumidosRespuesta(Respuesta respuesta) {
		this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getSolucion());		
	}
}