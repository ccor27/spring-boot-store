package com.api.university.service;

import com.api.university.model.Subject;
import com.api.university.model.Teacher;
import com.api.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher findById(Long id){
        return teacherRepository.findById(id).orElse(null);
    }
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher updateData(Long id,Teacher teacherUpdated){
        Teacher teacher = findById(id);
        if(teacher!=null){
            teacher.setName(teacherUpdated.getName());
            teacher.setLastName(teacherUpdated.getLastName());
            teacher.setDegree(teacherUpdated.getDegree());
            teacher.setEmail(teacherUpdated.getEmail());
            teacher.setInstitutionalEmail(teacherUpdated.getInstitutionalEmail());
            return teacherRepository.save(teacher);
        }else{
            return null;
        }
    }
    public Teacher assignSubject(Subject subject,Long id) {
        Teacher t = findById(id);
        if(t!=null){
            t.setSubject(subject);
            return teacherRepository.save(t);
        }else{
            return null;
        }
    }
    public Teacher removeSubject(Long id){
        Teacher t = findById(id);
        if(t!=null){
            t.setSubject(null);
            return teacherRepository.save(t);
        }else{
         return null;
        }
    }
}
