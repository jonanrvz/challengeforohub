package com.oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias;

import oraclenexteducation.challengeforohub.dto.etiquetas.categorias.DatosResumidosCategoria;
import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosListadoSubcategoria(
		Long id,
		String nombre,
		DatosResumidosCategoria categoria
		) {

	public DatosListadoSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre(),
				new DatosResumidosCategoria(subcategoria.getEtiquetaPadre())
			);
	}
}