package com.oraclenexteducation.challengeforohub.dto.etiquetas.categorias;

import java.util.List;

import oraclenexteducation.challengeforohub.dto.etiquetas.subcategorias.DatosResumidosSubcategoria;
import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosCompletosCategoria (
		Long id,
		String nombre,
		List<DatosResumidosSubcategoria> subcategorias
	) {

	public DatosCompletosCategoria(Etiqueta categoria) {
		this(
				categoria.getId(),
				categoria.getNombre(),
				categoria.getEtiquetasHijas().stream().map(DatosResumidosSubcategoria::new).toList()
			);
	}
}