package edu.avale1648.internationale.exceptions;

public class GroupNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GroupNotFoundException(Integer id) {
		// TODO Auto-generated constructor stub
		super(String.format("Group not found: %d", id));
	}
}
