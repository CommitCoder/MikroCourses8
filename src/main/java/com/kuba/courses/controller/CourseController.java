package com.kuba.courses.controller;


import com.kuba.courses.model.Course;
import com.kuba.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{code}")
    public Course getCourse(@PathVariable String code){
        return courseService.getCourse(code);
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("/{code}")
    public void deleteCourse(@PathVariable String code){
        courseService.deleteCourse(code);
    }

    @PutMapping("/{code}")
    public Course putCourse(@PathVariable String code, @RequestBody Course course){
        return courseService.putCourse(code, course);
    }

    @PatchMapping("/{code}")
    public Course patchCourse(@PathVariable String code, @RequestBody Course course){
        return courseService.patchCourse(code, course);
    }











}
