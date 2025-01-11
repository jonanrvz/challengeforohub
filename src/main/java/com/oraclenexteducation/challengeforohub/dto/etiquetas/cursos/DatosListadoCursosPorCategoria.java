package com.oraclenexteducation.challengeforohub.dto.etiquetas.cursos;

import oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias.DatosResumidosSubcategoria;
import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosListadoCursosPorCategoria(
		Long id,
		String nombre,
		DatosResumidosSubcategoria subcategoria
	) {

	public DatosListadoCursosPorCategoria(Etiqueta curso) {
		this(
				curso.getId(),
				curso.getNombre(),
				new DatosResumidosSubcategoria(curso.getEtiquetaPadre())
			);
	}
}