package com.task.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionGenerator extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    public ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse("Validation errors");
        for(FieldError x: ex.getFieldErrors())
            response.addValidationError(x.getField(), x.getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse response = new ErrorResponse("Validation errors");
        for(FieldError x: ex.getFieldErrors())
            response.addValidationError(x.getField(), x.getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomExceptions.ResourceNotFound.class)
    public ResponseEntity<Object> handleResourceNotFoundException(CustomExceptions.ResourceNotFound ex, WebRequest request){
        ErrorResponse response = new ErrorResponse(ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(CustomExceptions.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(CustomExceptions.BadRequest ex, WebRequest request){
        ErrorResponse response = new ErrorResponse(ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request){
        ErrorResponse response = new ErrorResponse("Data integrity violation");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex, WebRequest request){
        ErrorResponse response = new ErrorResponse("Access denied");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                          HttpStatus status, WebRequest request){
        ErrorResponse response = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(status).body(response);
    }

}
