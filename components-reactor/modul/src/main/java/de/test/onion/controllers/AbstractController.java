package de.test.onion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.test.onion.domain.exceptions.DuplicateObjectException;
import de.test.onion.domain.exceptions.ObjectDoesNotExistException;
import de.test.onion.dtos.ErrorResponseDto;
import de.test.onion.exceptions.IllegalIdException;

@CrossOrigin(origins = "http://localhost:4200")
public abstract class AbstractController {

	@ExceptionHandler(value = IllegalIdException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto handleIllegalIdException(IllegalIdException e) {

		// Todo more generic message and use e
		ErrorResponseDto errorResponse = new ErrorResponseDto("Invalid ID",
				"The ids of the url and the dto did not match up!");
		return errorResponse;
	}


	@ExceptionHandler(value = ObjectDoesNotExistException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponseDto handleObjectDoesNotExistException(ObjectDoesNotExistException e) {

		// Todo more generic message and use e
		ErrorResponseDto errorResponse = new ErrorResponseDto("Not found",
				"No object found");
		return errorResponse;
	}


	@ExceptionHandler(value = DuplicateObjectException.class)
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponseDto handleObjectDoesNotExistException(DuplicateObjectException e) {

		// Todo more generic message and use e
		ErrorResponseDto errorResponse = new ErrorResponseDto("Duplicate",
				"The object is already existing!");
		return errorResponse;
	}

}
