/**
 * 
 */
package io.swagger.constante;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public enum TipoError {

	SOLICITUD_INVALIDA("400"), 
	SERVICIO_INACCESIBLE("502"), 
	FUENTE_DE_DATOS("503"), 
	ERROR_INESPERADO("500");

	private String value;

	private TipoError(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

}
