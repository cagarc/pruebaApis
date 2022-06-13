/**
 * 
 */
package io.swagger.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.model.MensajeSalida;



/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public class DataValidator {


	public static ResponseEntity<MensajeSalida> validarResultado(BusinessException ex) {
		ResponseEntity<MensajeSalida> respuesta;
		switch (ex.getError()) {
	
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("400").mensajeSalida(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("502").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("503").mensajeSalida(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
		default:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("500").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

	
	public static ResponseEntity<MensajeSalida> validarResultado(ApplicationException ex) {
		ResponseEntity<MensajeSalida> respuesta;
		switch (ex.getError()) {
	
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("400").mensajeSalida(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("502").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("503").mensajeSalida(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
	
		default:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("500").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

	public static ResponseEntity<MensajeSalida> validarResultadoObj(Object exe) {
		ResponseEntity<MensajeSalida> respuesta;
		BusinessException ex = (BusinessException) exe;
		switch (ex.getError()) {
		case SOLICITUD_INVALIDA:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("400").mensajeSalida(ex.getMessage()),
					HttpStatus.BAD_REQUEST);
			break;
		case SERVICIO_INACCESIBLE:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("502").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		case FUENTE_DE_DATOS:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("503").mensajeSalida(ex.getMessage()),
					HttpStatus.SERVICE_UNAVAILABLE);
			break;
	
		default:
			respuesta = new ResponseEntity<>(new MensajeSalida().codigoRespuesta("500").mensajeSalida(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
			break;
		}

		return respuesta;
	}

}
