package io.swagger.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-12T02:03:20.587Z[GMT]")
public class ApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ApiException (int code, String msg) {
        super(msg);
    }
}
