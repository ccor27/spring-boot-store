package com.api.university.controller;

import com.api.university.model.Teacher;
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

    @PostMapping("/save")
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id") Long id){
        Teacher teacherFounded = teacherService.findById(id);
        if(teacherFounded!=null){
            return new ResponseEntity<>(teacherFounded,HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/find")
    public ResponseEntity<List<Teacher>> findAll(){
        List<Teacher> teacherList = teacherService.findAll();
        if(teacherList!=null){
            if(teacherList.size()>0){
                return new ResponseEntity<>(teacherList,HttpStatus.FOUND);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/data/{id}")
    public ResponseEntity<Teacher> updateData(@PathVariable("id") Long id, @RequestBody Teacher teacher){
        Teacher teacherUpdated = teacherService.updateData(id,teacher);
        if(teacherUpdated!=null){
            return new ResponseEntity<>(teacherUpdated,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
