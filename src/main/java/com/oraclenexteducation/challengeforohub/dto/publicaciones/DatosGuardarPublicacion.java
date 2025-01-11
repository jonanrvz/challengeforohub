package com.oraclenexteducation.challengeforohub.dto.publicaciones;

import oraclenexteducation.challengeforohub.modelo.Publicacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosGuardarPublicacion(
		@NotNull(message = "El id del curso es obligatorio")
		Long cursoId,

		@NotBlank(message = "El título es obligatorio")
		String titulo, 

		@NotBlank(message = "El mensaje es obligatorio")
		String mensaje
		) {

	public DatosGuardarPublicacion(Publicacion publicacion) {
		this(publicacion.getCurso().getId(), publicacion.getTitulo(), publicacion.getMensaje());
	}

}