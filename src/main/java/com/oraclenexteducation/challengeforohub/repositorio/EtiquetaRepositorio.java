package com.oraclenexteducation.challengeforohub.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import oraclenexteducation.challengeforohub.modelo.Etiqueta;
import oraclenexteducation.challengeforohub.modelo.Nivel;

public interface EtiquetaRepositorio extends JpaRepository<Etiqueta, Long>  {

	Page<Etiqueta> findAllByNivel(Nivel nivel, Pageable paginacion);

	Etiqueta findByIdAndNivel(Long id, Nivel nivel);

	boolean existsByIdAndNivel(Long id, Nivel nivel);

	Page<Etiqueta> findAllByNivelAndEtiquetaPadreId(Nivel nivel, Long etiquetaPadreId, Pageable paginacion);

}