package com.oraclenexteducation.challengeforohub.dto.etiquetas.cursos;

import oraclenexteducation.challengeforohub.dto.etiquetas.categorias.DatosResumidosCategoria;
import oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias.DatosResumidosSubcategoria;
import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosCompletosCurso (
		Long id,
		String nombre,
		DatosResumidosCategoria categoria,
		DatosResumidosSubcategoria subcategoria
	){

	public DatosCompletosCurso(Etiqueta curso) {
		this(
				curso.getId(),
				curso.getNombre(),
				new DatosResumidosCategoria(curso.getEtiquetaPadre().getEtiquetaPadre()),
				new DatosResumidosSubcategoria(curso.getEtiquetaPadre())
			);
	}
}