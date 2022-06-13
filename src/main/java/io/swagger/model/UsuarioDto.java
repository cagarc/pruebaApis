/**
 * 
 */
package io.swagger.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 12 jun. 2022
 */
public class UsuarioDto {

	@JsonProperty("idusuario")
	private UUID id;

	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("contrasena")
	private String contrasena;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}

}
