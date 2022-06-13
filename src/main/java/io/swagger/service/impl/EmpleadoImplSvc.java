/**
 * 
 */
package io.swagger.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.constante.TipoError;
import io.swagger.constante.TipoVacuna;
import io.swagger.model.EmpleadoDto;
import io.swagger.model.EmpleadoReporte;
import io.swagger.repository.ifc.IEmpleadoRepo;
import io.swagger.repository.ifc.IVacunaRepo;
import io.swagger.repository.model.Empleado;
import io.swagger.repository.model.Vacuna;
import io.swagger.service.ifc.IEmpleadoSvc;
import io.swagger.util.BusinessException;
import io.swagger.util.ConvertApis;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */

@Service
public class EmpleadoImplSvc implements IEmpleadoSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoImplSvc.class);

	@Autowired
	IEmpleadoRepo repository;

	@Autowired
	IVacunaRepo repositoryVacuna;

	@Override
	public EmpleadoDto registroEmpleado(EmpleadoDto empleado) throws BusinessException {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: registroEmpleado " + empleado);

		Empleado emplea = repository.save(ConvertApis.dtoToModel(empleado));
		LOGGER.info(" PROCESO FIN: registroEmpleado : PROCESO INGESO EXITOSO");

		return ConvertApis.modelToDto(emplea);
	}

	@Override
	public EmpleadoDto autualizarEmpleado(EmpleadoDto body) throws BusinessException {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: autualizarEmpleado " + body);
		Empleado emple = ConvertApis.dtoToModel(body);
		Empleado emplea = repository.save(emple);
		LOGGER.info(" PROCESO FIN: autualizarEmpleado : PROCESO ACTUALIZAR EXITOSO");
		return ConvertApis.modelToDto(emplea);
	}

	public void postEmpleadoEliminarEmpleado(String cedula) throws BusinessException {
		LOGGER.info(" PROCESO INICIO: EliminarEmpleado " + cedula);

		Empleado empleado = repository.consultaXCedula(cedula);
		if (empleado != null) {
			repository.deleteById(empleado.getId());
		} else {
			throw new BusinessException(String.format("El num. identificación: [%s] no encuentra registrado", cedula),
					TipoError.SOLICITUD_INVALIDA);
		}

		LOGGER.info(" PROCESO FIN: EliminarEmpleado : PROCESO ELIMINAR EXITOSO");

	}

	@Override
	public List<EmpleadoDto> getConsultaEmpleado() throws BusinessException {
		// TODO Auto-generated method stub
		List<Empleado> empleado = repository.findAll();
		if (!empleado.isEmpty()) {
			return ConvertApis.listModelToType(empleado);
		} else {
			LOGGER.info(" PROCESO FIN: getConsultaEmpleado : PROCESO CONSULTA EXITOSO");
			throw new BusinessException(String.format("No encontro registrado"), TipoError.SOLICITUD_INVALIDA);
		}

	}

	@Override
	public List<EmpleadoReporte> getConsultaEmpleadoXVacunacion(EstadoVacunacion estadoVacunacion)
			throws BusinessException {
		// TODO Auto-generated method stub
		List<Empleado> empleados = repository.consultaXEstadoVacuna(estadoVacunacion);

		List<EmpleadoReporte> respuesta = new ArrayList<>();
		EmpleadoReporte item;
		if (!empleados.isEmpty()) {

			for (Empleado empleado : empleados) {
				item = new EmpleadoReporte();
				item.setApellido(empleado.getApellido());
				item.setNombre(empleado.getNombre());
				item.setCedula(empleado.getCedula());
				item.setDireccionDomicilio(empleado.getDireccionDomicilio());
				item.setEmail(empleado.getEmail());
				item.setEstaVacunado(empleado.getEstaVacunado());
				item.setFechaNacimiento(empleado.getFechaNacimiento());
				item.setTelefonoMovil(empleado.getTelefonoMovil());
				Vacuna vacuna = repositoryVacuna.consultaVacuna(empleado.getCedula());
				if (vacuna != null) {
					item.setFechaVacunacion(vacuna.getFechaVacunacion());
					item.setNumeroDosis(vacuna.getNumeroDosis());
					item.setTipoVacuna(vacuna.getTipoVacuna());
				}
				respuesta.add(item);
			}

			return respuesta;
		} else {
			LOGGER.info(" PROCESO FIN: getConsultaEmpleado : PROCESO CONSULTA EXITOSO");
			throw new BusinessException(String.format("No encontro registrado"), TipoError.SOLICITUD_INVALIDA);
		}
	}

	@Override
	public List<EmpleadoReporte> getConsultaEmpleadoXTipoVacunacion(TipoVacuna tipoVacuna) throws BusinessException {
		// TODO Auto-generated method stub
		List<Empleado> empleados = repository.consultaXTipoVacuna(tipoVacuna);

		List<EmpleadoReporte> respuesta = new ArrayList<>();
		EmpleadoReporte item;
		if (!empleados.isEmpty()) {

			for (Empleado empleado : empleados) {
				item = new EmpleadoReporte();
				item.setApellido(empleado.getApellido());
				item.setNombre(empleado.getNombre());
				item.setCedula(empleado.getCedula());
				item.setDireccionDomicilio(empleado.getDireccionDomicilio());
				item.setEmail(empleado.getEmail());
				item.setEstaVacunado(empleado.getEstaVacunado());
				item.setFechaNacimiento(empleado.getFechaNacimiento());
				item.setTelefonoMovil(empleado.getTelefonoMovil());
				Vacuna vacuna = repositoryVacuna.consultaVacuna(empleado.getCedula());
				if (vacuna != null) {
					item.setFechaVacunacion(vacuna.getFechaVacunacion());
					item.setNumeroDosis(vacuna.getNumeroDosis());
					item.setTipoVacuna(vacuna.getTipoVacuna());
				}
				respuesta.add(item);
			}

			return respuesta;
		} else {
			LOGGER.info(" PROCESO FIN: getConsultaEmpleado : PROCESO CONSULTA EXITOSO");
			throw new BusinessException(String.format("No encontro registrado"), TipoError.SOLICITUD_INVALIDA);
		}
	}

	@Override
	public List<EmpleadoReporte> getConsultaEmpleadoXFecha(Date fechaInicia, Date fechaFin) throws BusinessException {
		// TODO Auto-generated method stub
		List<Vacuna> vacunas = repositoryVacuna.getConsultaVacunaXFecha(fechaInicia, fechaFin);

		List<EmpleadoReporte> respuesta = new ArrayList<>();
		EmpleadoReporte item;
		if (!vacunas.isEmpty()) {

			for (Vacuna vacuna : vacunas) {
				item = new EmpleadoReporte();
				Empleado empleado = repository.consultaXCedula(vacuna.getCedula());
				if (empleado != null) {

					item.setApellido(empleado.getApellido());
					item.setNombre(empleado.getNombre());
					item.setCedula(empleado.getCedula());
					item.setDireccionDomicilio(empleado.getDireccionDomicilio());
					item.setEmail(empleado.getEmail());
					item.setEstaVacunado(empleado.getEstaVacunado());
					item.setFechaNacimiento(empleado.getFechaNacimiento());
					item.setTelefonoMovil(empleado.getTelefonoMovil());

					item.setFechaVacunacion(vacuna.getFechaVacunacion());
					item.setNumeroDosis(vacuna.getNumeroDosis());
					item.setTipoVacuna(vacuna.getTipoVacuna());

				}

				respuesta.add(item);
			}

			return respuesta;
		} else {
			LOGGER.info(" PROCESO FIN: getConsultaEmpleado : PROCESO CONSULTA EXITOSO");
			throw new BusinessException(String.format("No encontro registrado"), TipoError.SOLICITUD_INVALIDA);
		}
	}

}
