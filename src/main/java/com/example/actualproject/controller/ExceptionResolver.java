package com.example.actualproject.controller;

import com.example.actualproject.ErrorResponse;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class ExceptionResolver  {

        @ExceptionHandler(Exception.class)
        public HashMap<String,String> handlException(HttpServletRequest request,Exception e){
            HashMap<String,String> response = new HashMap<>();
            response.put("message",e.getMessage());
            return response;
        }

        @ExceptionHandler(MissingPathVariableException.class)
        public HashMap<String, String> handleMissingPathVariableException(HttpServletRequest request, MissingPathVariableException e) {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Required path variable is missing in this request. Please add it to your request.");
            return response;
        }

      /*  @ExceptionHandler(MethodArgumentNotValidException.class)
        public HashMap<String, String> ValidationError(HttpServletRequest request, MethodArgumentNotValidException e) {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "The Input isn't valid");
            return response;
        }
    */

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpServletRequest request ) {
            List<String> details = new ArrayList<>();
            for(ObjectError error : ex.getBindingResult().getAllErrors()) {
                details.add(error.getDefaultMessage());
            }
            ErrorResponse error = new ErrorResponse ("Validation Failed", details);
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }


  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public HashMap<String, String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
      HashMap<String, String> response = new HashMap<>();
      response.put("status", "fail");
      response.put("message", e.getLocalizedMessage());
      return response;
  }



}
