package com.api.university.controller;

import com.api.university.model.Course;
import com.api.university.model.Student;
import com.api.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id){
        Course course = courseService.findById(id);
        if(course!=null){
            return new ResponseEntity<>(course,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> courseList = courseService.findAll();
        if(courseList!=null){
            if(courseList.size()>0){
                return new ResponseEntity<>(courseList,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(courseList,HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/data/{id}")
    public ResponseEntity<Course> updateData(@PathVariable("id") Long id, @RequestBody Course course){
        Course courseUpdated = courseService.updateData(id,course);
        if(courseUpdated!=null){
            return new ResponseEntity<>(courseUpdated,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}/add/student")
    public ResponseEntity<Course> addStudent(@PathVariable("id") Long id, @RequestBody Student student){
        Course course = courseService.addStudent(id,student);
        if(course!=null){
            return new ResponseEntity<>(course,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}/remove/student")
    public ResponseEntity<Course> removeStudent(@PathVariable("id") Long id, @RequestBody Student student){
        Course course =courseService.removeStudent(id,student);
        if(course!=null){
            return new ResponseEntity<>(course,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*

       * Is finished:
          - student controller
          - teacher controller

     */
}
