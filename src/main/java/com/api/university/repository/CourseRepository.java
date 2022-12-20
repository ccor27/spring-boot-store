package com.api.university.repository;

import com.api.university.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    // create a query to drop a student of   REL_COURSE_STUDENT
}
