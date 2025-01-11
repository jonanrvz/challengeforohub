package com.oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias;

import java.util.List;

import oraclenexteducation.challengeforohub.dto.etiquetas.categorias.DatosResumidosCategoria;
import oraclenexteducation.challengeforohub.dto.etiquetas.cursos.DatosResumidosCurso;
import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosCompletosSubcategoria (
		Long id,
		String nombre,
		DatosResumidosCategoria categoria,
		List<DatosResumidosCurso> cursos
		) {

	public DatosCompletosSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre(),
				new DatosResumidosCategoria(subcategoria.getEtiquetaPadre()),
				subcategoria.getEtiquetasHijas().stream().map(DatosResumidosCurso::new).toList()
			);
	}
}