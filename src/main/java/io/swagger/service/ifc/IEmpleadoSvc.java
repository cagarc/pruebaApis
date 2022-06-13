/**
 * 
 */
package io.swagger.service.ifc;

import java.sql.Date;
import java.util.List;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.constante.TipoVacuna;
import io.swagger.model.EmpleadoDto;
import io.swagger.model.EmpleadoReporte;
import io.swagger.util.BusinessException;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public interface IEmpleadoSvc {

	public EmpleadoDto registroEmpleado(EmpleadoDto empleado) throws BusinessException;

	public EmpleadoDto autualizarEmpleado(EmpleadoDto body) throws BusinessException;

	public void postEmpleadoEliminarEmpleado(String cedula) throws BusinessException;

	public List<EmpleadoDto> getConsultaEmpleado() throws BusinessException;

	public List<EmpleadoReporte> getConsultaEmpleadoXVacunacion(EstadoVacunacion estadoVacunacion) throws BusinessException;
	
	public List<EmpleadoReporte> getConsultaEmpleadoXTipoVacunacion(TipoVacuna tipoVacuna)  throws BusinessException;
	
	public List<EmpleadoReporte> getConsultaEmpleadoXFecha(Date fechaInicia, Date fechaFin) throws BusinessException;
}
