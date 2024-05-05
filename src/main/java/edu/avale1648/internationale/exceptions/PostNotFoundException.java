package edu.avale1648.internationale.exceptions;

public class PostNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PostNotFoundException(Integer id) {
		// TODO Auto-generated constructor stub
		super(String.format("Post not found: %d", id));
	}
}
