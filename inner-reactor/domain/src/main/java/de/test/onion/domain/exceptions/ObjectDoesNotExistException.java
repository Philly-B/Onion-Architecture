package de.test.onion.domain.exceptions;

public class ObjectDoesNotExistException extends BaseOnionException {

	private static final long serialVersionUID = 1L;


	public ObjectDoesNotExistException(String message) {

		super(message);
	}

}
