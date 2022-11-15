package com.api.university.controller;

import com.api.university.model.Student;
import com.api.university.model.Subject;
import com.api.university.service.StudentService;
import com.api.university.service.SubjectService;
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
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/save")
    private ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
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
    @GetMapping("/find/all")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.FOUND);
    }
    @PutMapping("/update/date")
    public ResponseEntity<Student> updateData(@PathVariable("id") Long id, @RequestBody Student studentUpdated){

        if(studentUpdated!=null){
            Student student = studentService.updateDate(id,studentUpdated);
            if(student!=null){
                return new ResponseEntity<>(student,HttpStatus.OK);
            }else{
                //the student not exist
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            //the studentUpdated is null
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}/subject")
    public ResponseEntity<Student> assignSubject(@PathVariable("id")Long id, @RequestBody Subject  subject){
        Student student = studentService.findById(id);
        if(student!=null && subject!=null){
            subjectService.addStudent(student.getId(),student);
            return new ResponseEntity<>(student,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/remove/{id}/subject")
    public ResponseEntity<Student> removeSubject(@PathVariable("id")Long id,@RequestBody Subject subject){

        if(subject!=null){
            Student student = studentService.removeSubject(subject,id);
            if(student!=null){
                subjectService.removeStudent(subject.getId(), student);
                return new ResponseEntity<>(student,HttpStatus.OK);
            }else{
                //the student not exist
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }else{
            //the subject is null
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
