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

import io.swagger.repository.model.Empleado;
import io.swagger.repository.model.Vacuna;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */

@Repository
public interface IVacunaRepo extends JpaRepository<Vacuna, UUID>  {

	@Query(value = "SELECT * FROM vacuna where cedula = :cedula", nativeQuery = true)
	Vacuna consultaVacuna(@Param("cedula") String cedula);
	

	@Query(value = "select * FROM vacuna where fecha_vacunacion \\:\\:DATE between :fechaInicia and :fechaFin \\:\\:DATE ", nativeQuery = true)
	List<Vacuna> getConsultaVacunaXFecha(@Param("fechaInicia") Date fechaInicia,@Param("fechaFin") Date fechaFin);
}
