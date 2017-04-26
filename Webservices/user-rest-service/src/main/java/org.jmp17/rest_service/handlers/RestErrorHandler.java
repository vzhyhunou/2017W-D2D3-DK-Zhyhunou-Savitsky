package org.jmp17.rest_service.handlers;

import org.jmp17.rest_service.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
 
@ControllerAdvice
public class RestErrorHandler {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
 
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleUserNotFoundException(UserNotFoundException ex) {
        LOGGER.debug("handling 404 error on a user entry");
    }
}