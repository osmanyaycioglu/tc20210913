package com.training.spring.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyErrorHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setMsg(exp.getMessage());
        errorObjLoc.setCause(100);
        return errorObjLoc;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        StringBuffer bufferLoc = new StringBuffer();
        bufferLoc.append("Validation errors : ");
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            bufferLoc.append(objectErrorLoc.toString())
                     .append(" ----- ");
        }
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setMsg(bufferLoc.toString());
        errorObjLoc.setCause(200);
        return errorObjLoc;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final Exception exp) {
        exp.printStackTrace();
        ErrorObj errorObjLoc = new ErrorObj();
        errorObjLoc.setMsg(exp.getMessage());
        errorObjLoc.setCause(300);
        return errorObjLoc;
    }

}
