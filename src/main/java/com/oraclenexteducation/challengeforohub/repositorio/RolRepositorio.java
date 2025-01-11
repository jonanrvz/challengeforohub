package com.oraclenexteducation.challengeforohub.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import oraclenexteducation.challengeforohub.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

	Optional<Rol> findByNombre(String nombre);
}