package com.kuba.courses.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CourseExceptionHandler {


    public ResponseEntity<ErrorInfo> handleException(CourseException courseException){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(CourseError.COURSE_NOT_FOUND.equals(courseException.getCourseError())){
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(httpStatus).body(new ErrorInfo(courseException.getCourseError().getMessage()));

    }




}
