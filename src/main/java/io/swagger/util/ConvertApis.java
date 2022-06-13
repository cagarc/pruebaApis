/**
 * 
 */
package io.swagger.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.UsuarioDto;
import io.swagger.model.VacunaDto;
import io.swagger.repository.model.Empleado;
import io.swagger.repository.model.Usuario;
import io.swagger.repository.model.Vacuna;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public class ConvertApis {

	public static final Empleado dtoToModel(EmpleadoDto empleado) {
		return new ModelMapper().map(empleado, Empleado.class);
	}

	public static final EmpleadoDto modelToDto(Empleado empleado) {
		return new ModelMapper().map(empleado, EmpleadoDto.class);
	}

	public static List<EmpleadoDto> listModelToType(List<Empleado> empleados) {
		return empleados.stream().map(empleado -> (modelToDto(empleado))).collect(Collectors.toList());
	}

	public static final Vacuna dtoToModel(VacunaDto vacuna) {
		return new ModelMapper().map(vacuna, Vacuna.class);
	}

	public static final VacunaDto modelToDto(Vacuna vacuna) {
		return new ModelMapper().map(vacuna, VacunaDto.class);
	}

	public static final UsuarioDto modelToDto(Usuario empleado) {
		return new ModelMapper().map(empleado, UsuarioDto.class);
	}

	public static List<UsuarioDto> listModelToTyp(List<Usuario> usuarios) {
		return usuarios.stream().map(usuario -> (modelToDto(usuario))).collect(Collectors.toList());
	}

}
