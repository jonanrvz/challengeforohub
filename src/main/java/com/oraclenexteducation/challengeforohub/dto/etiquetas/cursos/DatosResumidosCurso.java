package com.oraclenexteducation.challengeforohub.dto.etiquetas.cursos;

import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosResumidosCurso (Long id, String nombre) {

	public DatosResumidosCurso(Etiqueta curso) {
		this(curso.getId(), curso.getNombre());
	}
}