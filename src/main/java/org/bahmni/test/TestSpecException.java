package org.bahmni.test;

public class TestSpecException extends RuntimeException{

	public TestSpecException(String message) {
		super(message);
	}

	public TestSpecException(String message, Throwable cause) {
		super(message, cause);
	}
}
