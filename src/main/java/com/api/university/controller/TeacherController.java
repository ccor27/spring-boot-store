package com.api.university.controller;

import com.api.university.model.Subject;
import com.api.university.model.Teacher;
import com.api.university.service.SubjectService;
import com.api.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.save(teacher),HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id")Long id){
       Teacher teacher = teacherService.findById(id);
       if(teacher!=null){
           return new ResponseEntity<>(teacher,HttpStatus.FOUND);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Teacher>> findAll(){
        List<Teacher> list = teacherService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping("/update/data/")
    public ResponseEntity<Teacher> update(@PathVariable("id") Long id,@RequestBody Teacher teacherUpdated){

        if(teacherUpdated!=null){
            Teacher teacher =teacherService.updateData(id,teacherUpdated);
            if (teacher!=null){
                return new ResponseEntity<>(teacher,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/update/{id}/subject")
    public ResponseEntity<Teacher> assignSubject(@PathVariable("id") Long id,@RequestBody Subject subject){
       Teacher teacher = teacherService.assignSubject(subject,id);
       if(teacher!=null){
           if(subjectService.assignTeacher(subject.getId(),teacher)!=null){
               return new ResponseEntity<>(teacher,HttpStatus.OK);
           }else{
               //the subject not exist
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
       }else{
           //the teacher not exist
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
    }
    @PutMapping("/remove/subject")
    public ResponseEntity<Teacher> removeSubject(@PathVariable("id") Long id,@RequestBody Subject subject){
        Teacher teacher = teacherService.removeSubject(id);
        if(teacher!=null){
            subjectService.removeTeacher(subject.getId());
            return new ResponseEntity<>(teacher,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
