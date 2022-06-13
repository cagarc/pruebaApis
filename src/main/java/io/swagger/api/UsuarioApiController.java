/**
 * 
 */
package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.MensajeSalida;
import io.swagger.model.UsuarioDto;
import io.swagger.service.ifc.IUsuariuoSvc;
import io.swagger.util.BusinessException;
import io.swagger.util.DataValidator;
import io.swagger.util.EmpleadoValidator;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 13 jun. 2022
 */

@RestController
public class UsuarioApiController implements UsuarioApi {

	private static final Logger log = LoggerFactory.getLogger(UsuarioApiController.class);
	
	@Autowired
	IUsuariuoSvc servicio;

	@SuppressWarnings("unused")
	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public UsuarioApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}
	@Override
	public ResponseEntity<?> getConsultaUsuario() {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CONSULTA USUARIO");
				List<UsuarioDto> respues = servicio.consultaUsuario();
				log.info("FIN PROCESO DE CONSULTA USUARIO");
				respuesta = EmpleadoValidator.validarResultado(respues);
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CONSULTA USUARIO", e.getMessage());
				return DataValidator.validarResultado(e);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				salida.codigoRespuesta("9999");
				salida.setMensajeSalida(e.getMessage());
				return new ResponseEntity<MensajeSalida>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MensajeSalida>(HttpStatus.NOT_IMPLEMENTED);
	}

}
