package com.TheVeggieCart.Exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> generalExceptionHandler(Exception ex, WebRequest request) {
        log.error("An unexpected error occurred", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException ex, WebRequest request) {
        log.warn("No handler found for the requested endpoint" , ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> notValidExceptionHandler(MethodArgumentNotValidException ex, WebRequest request) {
        log.warn("Invalid request arguments" , ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(UserNotFoundException ex, WebRequest request) {
        log.error("User not found", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VegetableNotFoundException.class)
    public ResponseEntity<ErrorDetails> vegetableNotFoundExceptionHandler(VegetableNotFoundException ex, WebRequest request) {
        log.error("Vegetable not found", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<ErrorDetails> cartItemNotFoundExceptionHandler(CartItemNotFoundException ex, WebRequest request) {
        log.error("Cart item not found", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetails> orderNotFoundExceptionHandler(OrderNotFoundException ex, WebRequest request) {
        log.error("Order not found", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeedbackNotFoundException.class)
    public ResponseEntity<ErrorDetails> feedbackNotFoundExceptionHandler(FeedbackNotFoundException ex, WebRequest request) {
        log.error("Feedback not found", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorDetails> invalidRequestExceptionHandler(InvalidRequestException ex, WebRequest request) {
        log.error("Invalid request", ex);
        return new ResponseEntity<>(new ErrorDetails(ex.getMessage(), request.getDescription(false) , LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
