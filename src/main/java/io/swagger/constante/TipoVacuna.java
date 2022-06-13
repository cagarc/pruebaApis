/**
 * 
 */
package io.swagger.constante;

/**
 * @author GIZLOPC-34
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public enum TipoVacuna {

	SPUTNIK("SPUTNIK"), ASTRAZENECA("ASTRAZENECA"), PFIZER("PFIZER"), JHONSONJHONSON("JHONSONJHONSON");

	private String value;

	TipoVacuna(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static TipoVacuna fromValue(String value) {
		for (TipoVacuna b : TipoVacuna.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}

}
