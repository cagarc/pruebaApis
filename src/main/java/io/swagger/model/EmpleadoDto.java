package io.swagger.model;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.constante.EstadoVacunacion;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;


/**
 * EmpleadoDto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-12T02:03:20.587Z[GMT]")

public class EmpleadoDto {
	
	@JsonProperty("idempleado")
	private UUID id = null;

	@NotNull
	@JsonProperty("nombre")
	private String nombre = null;

	@NotNull
	@JsonProperty("apellido")
	private String apellido = null;

	@Pattern(regexp = "[0-9]*")
	@NotNull(message = "numero de cedula no puede estar vacío")
	@JsonProperty("cedula")
	private String cedula = null;

	@Email
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

	public EmpleadoDto id(UUID id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@Schema(description = "")

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public EmpleadoDto nombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	/**
	 * Get nombre
	 * 
	 * @return nombre
	 **/
	@Schema(description = "")

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EmpleadoDto apellido(String apellido) {
		this.apellido = apellido;
		return this;
	}

	/**
	 * Get apellida
	 * 
	 * @return apellida
	 **/
	@Schema(description = "")

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public EmpleadoDto cedula(String cedula) {
		this.cedula = cedula;
		return this;
	}

	/**
	 * Get cedula
	 * 
	 * @return cedula
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public EmpleadoDto email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@Schema(description = "")

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EmpleadoDto empleadoDto = (EmpleadoDto) o;
		return Objects.equals(this.id, empleadoDto.id) && Objects.equals(this.nombre, empleadoDto.nombre)
				&& Objects.equals(this.apellido, empleadoDto.apellido)
				&& Objects.equals(this.cedula, empleadoDto.cedula) && Objects.equals(this.email, empleadoDto.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, apellido, cedula, email);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EmpleadoDto {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
		sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
		sb.append("    cedula: ").append(toIndentedString(cedula)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
