/**
 * 
 */
package io.swagger.constante;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public enum EstadoVacunacion {

	VACUNADO("VACUNADO"), NOVACUNADO("NOVACUNADO");

	private String value;

	EstadoVacunacion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static EstadoVacunacion fromValue(String value) {
		for (EstadoVacunacion b : EstadoVacunacion.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

}
