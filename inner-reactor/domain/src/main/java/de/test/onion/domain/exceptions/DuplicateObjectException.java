package de.test.onion.domain.exceptions;

public class DuplicateObjectException extends BaseOnionException {

	private static final long serialVersionUID = 1L;


	public DuplicateObjectException(String message) {

		super(message);
	}
}
