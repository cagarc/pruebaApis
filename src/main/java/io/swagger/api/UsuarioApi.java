/**
 * 
 */
package io.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.MensajeSalida;
import io.swagger.model.UsuarioDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 13 jun. 2022
 */
public interface UsuarioApi {

	@Operation(summary = "INICIA PROCESO DE CONSULTA USUARIO", description = "", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = UsuarioDto.class)))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensajeSalida.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MensajeSalida.class))) })
	@RequestMapping(value = "/usuario", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<?> getConsultaUsuario();
}
