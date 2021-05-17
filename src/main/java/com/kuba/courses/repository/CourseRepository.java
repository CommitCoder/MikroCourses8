package com.kuba.courses.repository;


import com.kuba.courses.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


// nie musimy dawać adnotacji @Repository bo dziedziczymy po MongoRepository które jest już Repository
//@Repository
public interface CourseRepository extends MongoRepository<Course, String> {



}
