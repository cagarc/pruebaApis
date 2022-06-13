package io.swagger.service.ifc;

import java.util.List;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.UsuarioDto;
import io.swagger.util.BusinessException;

public interface IUsuariuoSvc {

	public UsuarioDto registroUsuario(EmpleadoDto empleado) throws BusinessException;
	
	public List<UsuarioDto> consultaUsuario() throws BusinessException;
}
