package com.api.university.service;

import com.api.university.model.Course;
import com.api.university.model.Student;
import com.api.university.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course save(Course course){
        return courseRepository.save(course);
    }
    public Course findById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public Course updateData(Long id, Course course){
        Course courseToUpdate = findById(id);
        if(courseToUpdate!=null){
            courseToUpdate.setName(course.getName());
            return courseRepository.save(courseToUpdate);
        }else{
        return null;
        }
    }
    public Course addStudent(Long id, Student student){
        Course course = findById(id);
        if(course!=null && student!=null){
            course.addStudent(student);
            return courseRepository.save(course);
        }else{
            System.out.println("curso o student son null");
            return null;
        }
    }
   public Course removeStudent(Long id, Student student){
        Course course = findById(id);
        if(course!=null && student!=null){
            course.removeStudent(student);
            return courseRepository.save(course);
        }else{
            return null;
        }
   }
}
