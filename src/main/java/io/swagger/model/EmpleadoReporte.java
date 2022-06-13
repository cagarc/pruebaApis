/**
 * 
 */
package io.swagger.model;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.constante.TipoVacuna;

/**
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public class EmpleadoReporte {

	@JsonProperty("nombre")
	private String nombre = null;

	@JsonProperty("apellido")
	private String apellido = null;

	@JsonProperty("cedula")
	private String cedula = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("fechaNacimiento")
	private Date fechaNacimiento = null;

	@JsonProperty("direccionDomicilio")
	private String direccionDomicilio = null;

	@JsonProperty("telefonoMovil")
	private String telefonoMovil = null;

	@JsonProperty("estaVacunado")
	private EstadoVacunacion estaVacunado;

	@JsonProperty("tipoVacuna")
	private TipoVacuna tipoVacuna;

	@JsonProperty("fechaVacunacion")
	private Date fechaVacunacion;

	@JsonProperty("numeroDosis")
	private int numeroDosis;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccionDomicilio() {
		return direccionDomicilio;
	}

	public void setDireccionDomicilio(String direccionDomicilio) {
		this.direccionDomicilio = direccionDomicilio;
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public EstadoVacunacion getEstaVacunado() {
		return estaVacunado;
	}

	public void setEstaVacunado(EstadoVacunacion estaVacunado) {
		this.estaVacunado = estaVacunado;
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
		return "EmpleadoReporte [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", email="
				+ email + ", fechaNacimiento=" + fechaNacimiento + ", direccionDomicilio=" + direccionDomicilio
				+ ", telefonoMovil=" + telefonoMovil + ", estaVacunado=" + estaVacunado + ", tipoVacuna=" + tipoVacuna
				+ ", fechaVacunacion=" + fechaVacunacion + ", numeroDosis=" + numeroDosis + "]";
	}

}
