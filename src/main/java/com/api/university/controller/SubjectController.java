package com.api.university.controller;

import com.api.university.model.Course;
import com.api.university.model.Subject;
import com.api.university.model.Teacher;
import com.api.university.service.SubjectService;
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

    @PostMapping("/save")
    public ResponseEntity<Subject> save(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Subject> findById(@PathVariable("id") Long id){
        Subject subject = subjectService.findById(id);
        if(subject!=null){
            return new ResponseEntity<>(subject,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<List<Subject>> findAll(){
        List<Subject> subjectList = subjectService.findAll();
        if(subjectList!=null){
            if(subjectList.size()>0){
                showRelationShipSubjectTeacher(subjectList);
                return new ResponseEntity<>(subjectList,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(subjectList,HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Subject> updateData(@PathVariable("id") Long id, @RequestBody Subject subject){
        Subject subjectUpdated = subjectService.updateData(id,subject);
        if(subjectUpdated!=null){
            return new ResponseEntity<>(subjectUpdated,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}/add/teacher")
    public ResponseEntity<Subject> assignTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher){
        Subject subject = subjectService.assignTeacher(id,teacher);
        if(subject!=null){
            System.out.println("subject: "+subject.getName()+" it's teacher is: "+teacher.getName());
            //System.out.println(teacher.data());
            return new ResponseEntity<>(subject,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
    @PutMapping("update/{id}/remove/teacher")
    public ResponseEntity<Subject> removeTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacher){
        Subject subject = subjectService.removeTeacher(id,teacher);
        if(subject!=null){
            return new ResponseEntity<>(subject,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping("/update/{id}/add/course")
    public ResponseEntity<Subject> assignCourse(@PathVariable("id") Long id, @RequestBody Course course){
      Subject subject =  subjectService.assignCourse(id,course);
      if(subject!=null){
          return new ResponseEntity<>(subject,HttpStatus.OK);
      }else{
          return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
      }
    }
    @PutMapping("/update/{id}/remove/course")
    public ResponseEntity<Subject> removeCourse(@PathVariable("id") Long id, @RequestBody Course course){
        Subject subject =  subjectService.removeCourse(id,course);
        if(subject!=null){
            return new ResponseEntity<>(subject,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    private void showRelationShipSubjectTeacher(List<Subject> list){

        for (Subject subject:list ) {
            if(subject.getTeacher()!=null) {
                System.out.print("Subject: " + subject.getName() + " | ");
                System.out.println("Subject's teacher: " + subject.getTeacher().getName());
                System.out.println("");
            }
        }
    }

}

