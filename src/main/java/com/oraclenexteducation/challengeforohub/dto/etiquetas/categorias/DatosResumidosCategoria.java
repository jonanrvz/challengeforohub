package com.oraclenexteducation.challengeforohub.dto.etiquetas.categorias;

import oraclenexteducation.challengeforohub.modelo.Etiqueta;

public record DatosResumidosCategoria(Long id, String nombre) {

	public DatosResumidosCategoria(Etiqueta categoria) {
		this(categoria.getId(), categoria.getNombre());
	}
}