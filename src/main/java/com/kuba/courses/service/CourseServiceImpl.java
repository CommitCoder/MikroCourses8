package com.kuba.courses.service;

import com.kuba.courses.exception.CourseError;
import com.kuba.courses.exception.CourseException;
import com.kuba.courses.model.Course;
import com.kuba.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(String code) {
        return courseRepository.findById(code).orElseThrow(()-> new CourseException(CourseError.COURSE_NOT_FOUND));
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String code) {
        Course course = courseRepository.findById(code).orElseThrow(() -> new CourseException(CourseError.COURSE_NOT_FOUND));
        courseRepository.delete(course);
    }

    @Override
    public Course putCourse(String code, Course course) {

        return courseRepository.findById(code).map(
                courseFromDb -> {

                    //validate to do @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                    courseFromDb.setCode(course.getCode());
                    courseFromDb.setDescription(course.getDescription());

                    return courseRepository.save(courseFromDb);
//                    private String code;
//                    private String name;
//                    private String description;
//                    private LocalDateTime startDate;
//                    private LocalDateTime endDate;
//                    private Long participantsLimit;
//                    private Long participantsNumber;
                }
        ).orElseThrow(() -> new CourseException(CourseError.COURSE_NOT_FOUND));


    }

    @Override
    public Course patchCourse(String code, Course course) {
        return courseRepository.findById(code).map(
                courseFromDb ->{

                    if(!StringUtils.isEmpty(course.getName())){
                        courseFromDb.setName(course.getName());
                    }


                    return courseRepository.save(courseFromDb);
                }
        ).orElseThrow(()->new CourseException(CourseError.COURSE_NOT_FOUND));
    }


}
