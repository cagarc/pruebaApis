/**
 * 
 */
package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.MensajeSalida;
import io.swagger.model.VacunaDto;
import io.swagger.service.ifc.IVacunaSvc;
import io.swagger.util.BusinessException;
import io.swagger.util.DataValidator;
import io.swagger.util.EmpleadoValidator;
import io.swagger.util.VacunaValidator;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */

@RestController
public class VacunaApiController implements VacunaApi {

	private static final Logger log = LoggerFactory.getLogger(VacunaApiController.class);

	private final HttpServletRequest request;
	
	@Autowired
	IVacunaSvc servicio;
	
	private final ObjectMapper objectMapper;
	
	@org.springframework.beans.factory.annotation.Autowired
	public VacunaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	
	@Override
	public ResponseEntity<?> postRegistroVacuna(@Valid VacunaDto body) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CREAR REGISTRO DE VACUNA");
				VacunaDto vacuna = servicio.postRegistroVacuna(body);
				respuesta = VacunaValidator.validarResultado(vacuna);
				log.info("FIN PROCESO DE CREAR REGISTRO DE VACUNA");
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CREAR REGISTRO DE VACUNA", e.getMessage());
				return DataValidator.validarResultado(e);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MensajeSalida>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MensajeSalida>(HttpStatus.NOT_IMPLEMENTED);
	}

	
}
