package com.oraclenexteducation.challengeforohub.seguridad;

public record DatosTokensIngreso(
		DatosCompletosToken accessToken, 
		DatosCompletosToken refreshToken
		) {
}