package edu.avale1648.internationale.exceptions;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Integer id) {
	// TODO Auto-generated constructor stub
		super(String.format("User not found: %d", id));
	}
}
