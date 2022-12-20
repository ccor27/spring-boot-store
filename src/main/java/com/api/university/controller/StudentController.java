package com.api.university.controller;

import com.api.university.model.Student;
import com.api.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id){
        Student student = studentService.findById(id);
        if(student!=null){
            return new ResponseEntity<>(student,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> studentList = studentService.findAll();
        if(studentList!=null){
            if(studentList.size()>0){
                return new ResponseEntity<>(studentList,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/data/{id}")
    public ResponseEntity<Student> updateData(@PathVariable("id") Long id, @RequestBody Student student){
        Student studentUpdated = studentService.updateData(id,student);
        if(studentUpdated!=null){
            return new ResponseEntity<>(studentUpdated,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
