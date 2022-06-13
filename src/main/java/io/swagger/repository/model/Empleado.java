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

import io.swagger.constante.EstadoVacunacion;



/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idempleado", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "cedula", unique = true)
	private String cedula;

	@Column(name = "email")
	private String email;

	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento = null;

	@Column(name = "direccionDomicilio")
	private String direccionDomicilio = null;

	@Column(name = "telefonoMovil")
	private String telefonoMovil = null;

	@Enumerated(EnumType.STRING)
	@Column(name = "estaVacunado")
	private EstadoVacunacion estaVacunado;

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", email=" + email + "]";
	}

}
