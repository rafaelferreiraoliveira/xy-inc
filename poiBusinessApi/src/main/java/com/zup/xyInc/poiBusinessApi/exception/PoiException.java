package com.zup.xyInc.poiBusinessApi.exception;

/**
 * Exceção padrão a ser lançada pela API
 * 
 * @author rafael
 *
 */
public class PoiException extends Exception {

	private static final long serialVersionUID = 368511963559467116L;

	public PoiException() {}

    public PoiException(String message) {
        super(message);
    }

    public PoiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoiException(Throwable cause) {
        super(cause);
    }
}
