/**
 * 
 */
package io.swagger.repository.ifc;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.constante.TipoVacuna;
import io.swagger.repository.model.Empleado;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */

@Repository
public interface IEmpleadoRepo extends JpaRepository<Empleado, UUID> {

	@Query(value = "delete	FROM empleado where cedula = :cedula", nativeQuery = true)
	boolean eliminarEmpleado(@Param("cedula") String cedula);

	@Query(value = "select * FROM empleado where cedula = :cedula", nativeQuery = true)
	Empleado consultaXCedula(@Param("cedula") String cedula);

	@Query(value = "select * FROM empleado where esta_vacunado = :#{#estadoVacunacion.name()}", nativeQuery = true)
	List<Empleado> consultaXEstadoVacuna(@Param("estadoVacunacion") EstadoVacunacion estadoVacunacion);

	@Query(value = "select * FROM empleado where esta_vacunado = :#{#tipoVacuna.name()}", nativeQuery = true)
	List<Empleado> consultaXTipoVacuna(@Param("tipoVacuna") TipoVacuna tipoVacuna);

}
