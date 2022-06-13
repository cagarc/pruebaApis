/**
 * 
 */
package io.swagger.util;

import io.swagger.constante.TipoError;

/**
 * @author Cesar Garcia
 * @singe 11 jun. 2022
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TipoError error;

	public ApplicationException(String mensaje, TipoError error) {
		super(mensaje);
		this.error = error;
	}

	public ApplicationException(String mensaje, TipoError error, Throwable causa) {
		super(mensaje, causa);
		this.error = error;
	}

	public ApplicationException(String mensaje) {
		super(mensaje);
		this.error = TipoError.ERROR_INESPERADO;
	}

	public TipoError getError() {
		return error;
	}

}
