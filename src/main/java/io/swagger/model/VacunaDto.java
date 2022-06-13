/**
 * 
 */
package io.swagger.model;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.constante.TipoVacuna;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public class VacunaDto {

	@JsonProperty("id")
	private UUID id = null;
	
	@JsonProperty("cedula")
	private String cedula;
	
	@JsonProperty("tipoVacuna")
	private TipoVacuna tipoVacuna;
	
	@JsonProperty("fechaVacunacion")
	private Date fechaVacunacion;
	
	@JsonProperty("numeroDosis")
	private int numeroDosis;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public TipoVacuna getTipoVacuna() {
		return tipoVacuna;
	}

	public void setTipoVacuna(TipoVacuna tipoVacuna) {
		this.tipoVacuna = tipoVacuna;
	}

	public Date getFechaVacunacion() {
		return fechaVacunacion;
	}

	public void setFechaVacunacion(Date fechaVacunacion) {
		this.fechaVacunacion = fechaVacunacion;
	}

	public int getNumeroDosis() {
		return numeroDosis;
	}

	public void setNumeroDosis(int numeroDosis) {
		this.numeroDosis = numeroDosis;
	}

	@Override
	public String toString() {
		return "VacunaDto [id=" + id + ", cedula=" + cedula + ", tipoVacuna=" + tipoVacuna + ", fechaVacunacion="
				+ fechaVacunacion + ", numeroDosis=" + numeroDosis + "]";
	}
	
	
}
