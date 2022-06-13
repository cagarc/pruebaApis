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

import io.swagger.model.VacunaDto;
import io.swagger.model.MensajeSalida;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public class VacunaValidator {

	public static ResponseEntity<MensajeSalida> validarResultadoaByCreate(@Valid VacunaDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("500").mensajeSalida("El recurso no pudo ser creado"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>(
				new MensajeSalida().codigoRespuesta("201")
						.mensajeSalida(String.format("ID del recurso creado: [%s]", "resultado.getId().toString()")),
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
	 * VALIDAMOS EL CONTENIDO DEL RESULTADOS CUANDO ES "VacunaDto" PARA DEFINIR EL
	 * CONDIGO HTTP CORRESPONDIENTE
	 * 
	 * @param resultado
	 * @return
	 */
	public static ResponseEntity<?> validarResultado(VacunaDto resultado) {
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

	public static ResponseEntity<MensajeSalida> validarResultado1(@Valid VacunaDto resultado) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("500").mensajeSalida("LA PETICION NO SE PROCESADO EXITOSAMENTE"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(new MensajeSalida().codigoRespuesta("200").mensajeSalida("PROCESO EXITOSO"));
	}

	public static ResponseEntity<?> validarResultado(Optional<VacunaDto> resultado) {
		if (resultado.isEmpty()) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("204").mensajeSalida("NO SE ENCONTRARON RESULTADOS"),
					HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(resultado);

	}

	public static ResponseEntity<MensajeSalida> validarResultadoaByUpdate(@Valid VacunaDto resultado, UUID uuid,
			String identificacion) {
		if (resultado == null) {
			return new ResponseEntity<>(
					new MensajeSalida().codigoRespuesta("404").mensajeSalida(String
							.format("El recurso ID: [%s] - identificacion : [%s] no existe", uuid, identificacion)),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new MensajeSalida().codigoRespuesta("200")
				.mensajeSalida(String.format("Usuario con el ID: [%s] - identificacion : [%s] se actualizo con éxito",
						"resultado.getId().toString(), resultado.getCedula()")),
				HttpStatus.OK);
	}

}
