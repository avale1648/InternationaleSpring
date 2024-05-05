package edu.avale1648.internationale.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.avale1648.internationale.exceptions.PostNotFoundException;

@ControllerAdvice
public class PostNotFoundAdvice {
	@ResponseBody
	@ExceptionHandler(PostNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String postNotFoundHandler(PostNotFoundException ex) {
		return ex.getMessage();
	}
}
