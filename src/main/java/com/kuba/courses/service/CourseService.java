package com.kuba.courses.service;

import com.kuba.courses.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<Course> getCourses();
    Course getCourse(String code);
    Course addCourse(Course course);
    void deleteCourse(String course);
    Course putCourse(String code,Course course);
    Course patchCourse(String code, Course course);



}
