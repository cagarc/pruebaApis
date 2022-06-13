package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * MensajeSalida
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-12T02:03:20.587Z[GMT]")

public class MensajeSalida {
	@JsonProperty("codigoRespuesta")
	private String codigoRespuesta = null;

	@JsonProperty("mensajeSalida")
	private String mensajeSalida = null;

	public MensajeSalida codigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		return this;
	}

	/**
	 * Get codigoRespuesta
	 * 
	 * @return codigoRespuesta
	 **/
	@Schema(description = "")

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public MensajeSalida mensajeSalida(String mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
		return this;
	}

	/**
	 * Get mensajeSalida
	 * 
	 * @return mensajeSalida
	 **/
	@Schema(description = "")

	public String getMensajeSalida() {
		return mensajeSalida;
	}

	public void setMensajeSalida(String mensajeSalida) {
		this.mensajeSalida = mensajeSalida;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MensajeSalida mensajeSalida = (MensajeSalida) o;
		return Objects.equals(this.codigoRespuesta, mensajeSalida.codigoRespuesta)
				&& Objects.equals(this.mensajeSalida, mensajeSalida.mensajeSalida);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoRespuesta, mensajeSalida);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MensajeSalida {\n");

		sb.append("    codigoRespuesta: ").append(toIndentedString(codigoRespuesta)).append("\n");
		sb.append("    mensajeSalida: ").append(toIndentedString(mensajeSalida)).append("\n");
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
