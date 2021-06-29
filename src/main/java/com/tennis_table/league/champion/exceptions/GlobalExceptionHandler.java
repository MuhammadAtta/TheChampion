package com.tennis_table.league.champion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



/**
 * Catch the exception and return custom ApiError
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnexpectedServerErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApiError handleUnexpectedServerErrorException(UnexpectedServerErrorException ex) {
			return	new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage());
	}
	
	@ExceptionHandler(NoParticipantFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleInvalidRadiusException(NoParticipantFound ex) {
		return	new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
	}
	
}