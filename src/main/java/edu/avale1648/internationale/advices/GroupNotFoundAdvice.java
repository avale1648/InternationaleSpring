package edu.avale1648.internationale.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.avale1648.internationale.exceptions.GroupNotFoundException;

@ControllerAdvice
public class GroupNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(GroupNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String groupNotFoundHandler(GroupNotFoundException ex) {
		return ex.getMessage();
	}
}
