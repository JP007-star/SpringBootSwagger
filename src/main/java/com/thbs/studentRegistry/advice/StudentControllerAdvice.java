package com.thbs.studentRegistry.advice;


import com.thbs.studentRegistry.exception.StudentAlreadyExistException;
import com.thbs.studentRegistry.exception.StudentNotFoundException;
import com.thbs.studentRegistry.exception.StudentParameterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentParameterNotFoundException.class)
    public ResponseEntity<String> handleStudentParameterNotFoundException(StudentParameterNotFoundException studentParameterNotFoundException){
        return new ResponseEntity<String>(studentParameterNotFoundException.getErrorMessage(), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<String> handleStudentAlreadyExistException(StudentAlreadyExistException studentAlreadyExistException){
        return new ResponseEntity<String>(studentAlreadyExistException.getErrorMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException){
        return new ResponseEntity<String>(studentNotFoundException.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
}
