package com.api.university.controller;

import com.api.university.model.Student;
import com.api.university.model.Subject;
import com.api.university.model.Teacher;
import com.api.university.service.StudentService;
import com.api.university.service.SubjectService;
import com.api.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Subject> save(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Subject> findById(@RequestParam("id") Long id){
        Subject s = subjectService.findById(id);
        if(s!=null){
            return new ResponseEntity<>(s,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Subject>> findAll(){
        List<Subject> list = subjectService.findAll();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Subject> updateData(@PathVariable("id") Long id, @RequestBody Subject subject){
        Subject s = subjectService.updateData(id,subject);
        if(s!=null){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}/teacher")
    public ResponseEntity<Subject> assignTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher){
           Subject subject = subjectService.assignTeacher(id,teacher);
           if(subject!=null){

               if(teacherService.assignSubject(subject,teacher.getId())!=null){
                   return new ResponseEntity<>(subject,HttpStatus.OK);
               }else{
                   //the teacher not exist
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }
           }else{
               //the subject not exist
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
    }
    @DeleteMapping("/delete/teacher/{id}")
    public ResponseEntity<Subject> removeTeacher(@PathVariable("id") Long id){
        Subject s = subjectService.findById(id);
        if(s!=null){
            teacherService.removeSubject(s.getTeacher().getId());//id teacher
            s = subjectService.removeTeacher(id);//id subject
            if(s!=null){//is validated that the teacher be deleted successfully of the subject

                return new ResponseEntity<>(s,HttpStatus.OK);
            }else{
                //the subject did not have assigned teacher
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }else{
            //the subject not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}/student")
    public ResponseEntity<Subject> addStudent(@PathVariable("id") Long id, Student student){
        Subject s = subjectService.addStudent(id,student);
        if(s!=null && student!=null){
               s = subjectService.addStudent(id,student);
               studentService.addSubject(s,student.getId());
               return new ResponseEntity<>(s,HttpStatus.OK);
        }else{
            //the subject not exist or the student not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/remove/{id}/student")
    public ResponseEntity<Subject> removeStudent(@PathVariable("id")Long id, Student student){
        Subject subject = subjectService.removeStudent(id,student);
        if(subject!=null){
            studentService.removeSubject(subject,student.getId());
            return new ResponseEntity<>(subject,HttpStatus.OK);
        }else{

            //the subject not exist or the student not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
