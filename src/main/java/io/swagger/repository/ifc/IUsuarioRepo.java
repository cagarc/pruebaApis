/**
 * 
 */
package io.swagger.repository.ifc;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.swagger.repository.model.Usuario;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, UUID> {

	@Query(value = "SELECT idusuario, contrasena, usuario FROM public.usuario where usuario = :usuario", nativeQuery = true)
	Usuario consultaEmpleado(@Param("usuario") String usuario);
}
