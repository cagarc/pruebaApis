/**
 * 
 */
package io.swagger.util;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.model.UsuarioDto;
import io.swagger.model.MensajeSalida;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public class UsuarioValidator {

	public static ResponseEntity<MensajeSalida> validarResultadoaByCreate(@Valid UsuarioDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("500").mensajeSalida("El recurso no pudo ser creado"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(new MensajeSalida().codigoRespuesta("201")
				.mensajeSalida(String.format("ID del recurso creado: [%s] el usuario es [%s] y contraseña es la misma",
						resultado.getId().toString(), resultado.getUsuario())),
				HttpStatus.CREATED);
	}

	public static ResponseEntity<?> validarResultado(List<?> resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(new MensajeSalida().codigoRespuesta("500")
					.mensajeSalida("ALCO OCURRIO, NO PODIMOS OBTENER LO SOLICITADO"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("204").mensajeSalida("NO SE ENCONTRARON RESULTADOS"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}

	/**
	 * VALIDAMOS EL CONTENIDO DEL RESULTADOS CUANDO ES "UsuarioDto" PARA DEFINIR EL
	 * CONDIGO HTTP CORRESPONDIENTE
	 * 
	 * @param resultado
	 * @return
	 */
	public static ResponseEntity<?> validarResultado(UsuarioDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("500").mensajeSalida("LA SOLICITUD NO SE PROCESO EXITOSAMENTE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(resultado);
	}

	public static ResponseEntity<?> validarResultado(MensajeSalida resultado) {
		if (resultado != null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("500").mensajeSalida("LA SOLICITUD NO SE PROCESO EXITOSAMENTE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(resultado);
	}

	public static ResponseEntity<MensajeSalida> validarResultado1(@Valid UsuarioDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(new MensajeSalida().codigoRespuesta("500")
					.mensajeSalida("LA PETICION NO SE PROCESADO EXITOSAMENTE"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(new MensajeSalida().codigoRespuesta("200").mensajeSalida("PROCESO EXITOSO"));
	}

	public static ResponseEntity<?> validarResultado(Optional<UsuarioDto> resultado) {
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("204").mensajeSalida("NO SE ENCONTRARON RESULTADOS"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}

	public static ResponseEntity<MensajeSalida> validarResultadoaByUpdate(@Valid UsuarioDto resultado, UUID uuid,
			String identificacion) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("404").mensajeSalida(String
							.format("El recurso ID: [%s] - identificacion : [%s] no existe", uuid, identificacion)),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new MensajeSalida().codigoRespuesta("200")
				.mensajeSalida(String.format("Usuario con el ID: [%s] - usuario : [%s] se actualizo con éxito",
						resultado.getId().toString(), resultado.getUsuario())),
				HttpStatus.OK);
	}

}
