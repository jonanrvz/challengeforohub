package com.oraclenexteducation.challengeforohub.servicios;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import oraclenexteducation.challengeforohub.dto.usuarios.DatosCambioContrasena;
import oraclenexteducation.challengeforohub.dto.usuarios.DatosRegistroUsuario;
import oraclenexteducation.challengeforohub.modelo.Rol;
import oraclenexteducation.challengeforohub.modelo.Usuario;
import oraclenexteducation.challengeforohub.repositorio.RolRepositorio;
import oraclenexteducation.challengeforohub.repositorio.UsuarioRepositorio;
import oraclenexteducation.challengeforohub.seguridad.UsuarioSeguridad;

@Service
public class UsuarioServicio implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private RolRepositorio rolRepositorio;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepositorio.findByCorreo(correo);
		if (usuario.isPresent()) {
			return new UsuarioSeguridad(usuario.get());
		}
		throw new UsernameNotFoundException("Credenciales inválidas");
	}

	public void registrarUsuario(DatosRegistroUsuario datosUsuario) {
		String correo = datosUsuario.correo();
		if (usuarioRepositorio.existsByCorreo(correo)) {
			throw new RuntimeException("El correo electrónico ingresado ya se encuentra en uso");
		}

		Usuario usuario = new Usuario();
		usuario.setNombre(datosUsuario.nombre());
		usuario.setCorreo(correo);
		usuario.setContrasena(passwordEncoder.encode(datosUsuario.contrasena()));

		Rol rol = rolRepositorio.findByNombre("USUARIO").get();
		usuario.setRoles(List.of(rol));

		usuarioRepositorio.save(usuario);
	}

	public void asignarRolAUsuario(Long usuarioId, Long rolId) {
		Usuario usuario = usuarioRepositorio.getReferenceById(usuarioId);
		if(usuario == null) {
			throw new RuntimeException("Este usuario no existe");
		}

		Rol rol = rolRepositorio.getReferenceById(rolId);
		if(rol == null) {
			throw new RuntimeException("Este rol no existe");
		}

		if(usuario.getRoles().contains(rol)) {
			throw new RuntimeException("El usuario ya tiene ese rol");
		}

	 	usuario.getRoles().add(rol);

	}

	public void cambiarContrasena(Principal principal, DatosCambioContrasena datosContrasena) {
		Optional<Usuario> usuario = usuarioRepositorio.findByCorreo(principal.getName());
		if(!usuario.isPresent()) {
			throw new RuntimeException("Este usuario no existe");
		}

		if(!datosContrasena.contrasenaNueva().equals(datosContrasena.contrasenaConfirmacion()) ) {
			throw new RuntimeException("Las contraseñas nueva y su confirmación no coinciden");
		}

		String contrasenaBaseDatos = usuario.get().getContrasena();
		if(!passwordEncoder.matches(datosContrasena.contrasenaActual(), contrasenaBaseDatos)) {
			throw new RuntimeException("Credenciales inválidas");
		}

		usuario.get().setContrasena(passwordEncoder.encode(datosContrasena.contrasenaNueva()));
	}
}