package io.swagger.api;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.constante.TipoVacuna;
import io.swagger.model.EmpleadoDto;
import io.swagger.model.EmpleadoReporte;
import io.swagger.model.MensajeSalida;
import io.swagger.model.UsuarioDto;
import io.swagger.service.ifc.IEmpleadoSvc;
import io.swagger.service.ifc.IUsuariuoSvc;
import io.swagger.util.BusinessException;
import io.swagger.util.DataValidator;
import io.swagger.util.EmpleadoValidator;
import io.swagger.util.UsuarioValidator;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-12T02:03:20.587Z[GMT]")
@RestController
public class EmpleadoApiController implements EmpleadoApi {

	private static final Logger log = LoggerFactory.getLogger(EmpleadoApiController.class);

	@SuppressWarnings("unused")
	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	IEmpleadoSvc servicio;

	@Autowired
	IUsuariuoSvc servicioUsurio;

	@org.springframework.beans.factory.annotation.Autowired
	public EmpleadoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<?> postRegistroEmpleado(
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody EmpleadoDto body) {
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CREAR EMPLEADO");
				EmpleadoDto empleado = servicio.registroEmpleado(body);
				UsuarioDto usuario = servicioUsurio.registroUsuario(empleado);
				respuesta = UsuarioValidator.validarResultadoaByCreate(usuario);

				log.info("FIN PROCESO DE CREAR EMPLEADO");
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CREAR EMPLEADO", e.getMessage());
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

	@Override
	public ResponseEntity<?> putAutualizarEmpleado(EmpleadoDto body) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE ACTUALIZAR EMPLEADO");
				EmpleadoDto EMPLEADO = servicio.autualizarEmpleado(body);
				respuesta = EmpleadoValidator.validarResultado(EMPLEADO);
				log.info("FIN PROCESO DE ACTUALIZAR EMPLEADO");
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE ACTUALIZAR EMPLEADO", e.getMessage());
				return DataValidator.validarResultado(e);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				salida.codigoRespuesta("9999");
				salida.setMensajeSalida(e.getMessage());
				return new ResponseEntity<MensajeSalida>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MensajeSalida>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<?> deleteEliminarEmpleado(String cedula) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {

			try {
				log.info("INICIA PROCESO DE ELIMINAR EMPLEADO");
				servicio.postEmpleadoEliminarEmpleado(cedula);
				log.info("FIN PROCESO DE ELIMINAR EMPLEADO");
				return ResponseEntity.ok(null);
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE ELIMINAR EMPLEADO", e.getMessage());
				return DataValidator.validarResultado(e);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				salida.codigoRespuesta("9999");
				salida.setMensajeSalida(e.getMessage());
				return new ResponseEntity<MensajeSalida>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<MensajeSalida>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<?> getConsultaEmpleado() {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CONSULTA EMPLEADO");
				List<EmpleadoDto> respues = servicio.getConsultaEmpleado();
				log.info("FIN PROCESO DE CONSULTA EMPLEADO");
				respuesta = EmpleadoValidator.validarResultado(respues);
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CONSULTA EMPLEADO", e.getMessage());
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

	@Override
	public ResponseEntity<?> getConsultaEmpleadoXVacunacion(EstadoVacunacion estadoVacunacion) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CONSULTA EMPLEADO");
				List<EmpleadoReporte> respues = servicio.getConsultaEmpleadoXVacunacion(estadoVacunacion);
				log.info("FIN PROCESO DE CONSULTA EMPLEADO");
				respuesta = EmpleadoValidator.validarResultado(respues);
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CONSULTA EMPLEADO", e.getMessage());
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

	@Override
	public ResponseEntity<?> getConsultaEmpleadoXTipoVacunacion(TipoVacuna tipoVacuna) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		MensajeSalida salida = new MensajeSalida();
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CONSULTA EMPLEADO");
				List<EmpleadoReporte> respues = servicio.getConsultaEmpleadoXTipoVacunacion(tipoVacuna);
				log.info("FIN PROCESO DE CONSULTA EMPLEADO");
				respuesta = EmpleadoValidator.validarResultado(respues);
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CONSULTA EMPLEADO", e.getMessage());
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

	@Override
	public ResponseEntity<?> getConsultaEmpleadoXFecha(Date fechaInicia, Date fechaFin) {
		// TODO Auto-generated method stub
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			ResponseEntity<?> respuesta = null;
			try {
				log.info("INICIA PROCESO DE CONSULTA EMPLEADO");
				List<EmpleadoReporte> respues = servicio.getConsultaEmpleadoXFecha(fechaInicia, fechaFin);
				log.info("FIN PROCESO DE CONSULTA EMPLEADO");
				respuesta = EmpleadoValidator.validarResultado(respues);
				return respuesta;
			} catch (BusinessException e) {
				log.error("ERROR DE PROCESO DE CONSULTA EMPLEADO", e.getMessage());
				return DataValidator.validarResultado(e);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<MensajeSalida>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<MensajeSalida>(HttpStatus.NOT_IMPLEMENTED);
	}

}
