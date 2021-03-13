package com.epsilon.training.exceptions;

public class NotXmlSerializableException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public NotXmlSerializableException() {
		super();
	}
public NotXmlSerializableException(String msg) {
	super(msg);
	}
}
