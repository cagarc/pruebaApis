/**
 * 
 */
package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.model.EmpleadoDto;
import io.swagger.model.MensajeSalida;
import io.swagger.model.VacunaDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public interface VacunaApi {

	@Operation(summary = "INICIA PROCESO DE CREAR REGISTRO DE VACUNA", description = "", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = VacunaDto.class))),

			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = MensajeSalida.class))),

			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = MensajeSalida.class))) })
	@RequestMapping(value = "/vacuna/registroVacuna", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	ResponseEntity<?> postRegistroVacuna(
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody VacunaDto body);
}
