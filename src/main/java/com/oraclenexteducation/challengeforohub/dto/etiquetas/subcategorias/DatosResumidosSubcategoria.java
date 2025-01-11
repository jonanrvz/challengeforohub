package com.oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias;

import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosResumidosSubcategoria(
		Long id,
		String nombre
		) {

	public DatosResumidosSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre()
			);
	}
}