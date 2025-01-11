package com.oraclenexteducation.challengeforohub.dto.publicaciones;

import java.time.LocalDateTime;
import java.util.List;

import oraclenexteducation.challengeforohub.dto.respuestas.DatosResumidosRespuesta;
import oraclenexteducation.challengeforohub.dto.usuarios.DatosResumidosUsuario;
import oraclenexteducation.challengeforohub.modelo.EstadoPublicacion;
import oraclenexteducation.challengeforohub.modelo.Publicacion;

public record DatosListadoPublicacionPorCurso(
		Long publicacionId, 
		String titulo, 
		String mensaje, 
		LocalDateTime fechaCreacion, 
		EstadoPublicacion estado, 
		List<DatosResumidosRespuesta> respuestas,
		DatosResumidosUsuario autor
		) {

	public DatosListadoPublicacionPorCurso(Publicacion publicacion) {
		this(
				publicacion.getId(), 
				publicacion.getTitulo(), 
				publicacion.getMensaje(), 
				publicacion.getFechaCreacion(), 
				publicacion.getEstado(), 
				publicacion.getRespuestas().stream().map(DatosResumidosRespuesta::new).toList(),
				new DatosResumidosUsuario(publicacion.getAutor())
			);
	}
}