/**
 * 
 */
package io.swagger.repository.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.constante.TipoVacuna;



/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */

@Entity
@Table(name = "vacuna")
public class Vacuna implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idvacuna", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id = null;
	
	@Column(name = "cedula", unique = true)
	private String cedula;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoVacuna")
	private TipoVacuna tipoVacuna;
	
	@Column(name = "fechaVacunacion")
	private Date fechaVacunacion;
	
	@Column(name = "numeroDosis")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vacuna [id=" + id + ", cedula=" + cedula + ", tipoVacuna=" + tipoVacuna + ", fechaVacunacion="
				+ fechaVacunacion + ", numeroDosis=" + numeroDosis + "]";
	}
	
	

}
