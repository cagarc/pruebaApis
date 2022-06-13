/**
 * 
 */
package io.swagger.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.constante.TipoError;
import io.swagger.model.EmpleadoDto;
import io.swagger.model.UsuarioDto;
import io.swagger.repository.ifc.IUsuarioRepo;
import io.swagger.repository.model.Empleado;
import io.swagger.repository.model.Usuario;
import io.swagger.service.ifc.IUsuariuoSvc;
import io.swagger.util.BusinessException;
import io.swagger.util.ConvertApis;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */

@Service
public class UsuariuoImplSvc implements IUsuariuoSvc {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuariuoImplSvc.class);

	@Autowired
	IUsuarioRepo repository;

	@Override
	public UsuarioDto registroUsuario(EmpleadoDto empleado) throws BusinessException {
		// TODO Auto-generated method stub
		LOGGER.info(" PROCESO INICIO: registroUsuario " + empleado);

		Usuario user = new Usuario();
		String usuario;
		boolean bandera = true;
		int i = 0;
		do {
			usuario = empleado.getNombre().split(" ")[0].toString().charAt(i)
					+ empleado.getApellido().split(" ")[0].toString();

			Usuario usert = repository.consultaEmpleado(usuario.toLowerCase());
			if (usert == null) {
				bandera = false;
			}
			i++;
		} while (bandera);

		user.setContrasena(usuario.toLowerCase());
		user.setUsuario(usuario.toLowerCase());

		user = repository.save(user);
		
		LOGGER.info("FIN PROCESO DE CREAR USUARIO");
		return ConvertApis.modelToDto(user);
	}

	@Override
	public List<UsuarioDto> consultaUsuario() throws BusinessException {
		// TODO Auto-generated method stub
		List<Usuario> empleado = repository.findAll();
		if (!empleado.isEmpty()) {
			return ConvertApis.listModelToTyp(empleado);
		} else {
			LOGGER.info(" PROCESO FIN: getConsultaEmpleado : PROCESO CONSULTA EXITOSO");
			throw new BusinessException(String.format("No encontro registrado"), TipoError.SOLICITUD_INVALIDA);
		}
	}

}
