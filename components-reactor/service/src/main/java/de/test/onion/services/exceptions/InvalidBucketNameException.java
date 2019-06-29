package de.test.onion.services.exceptions;

public class InvalidBucketNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidBucketNameException(String message) {
		super(message);
	}

}
