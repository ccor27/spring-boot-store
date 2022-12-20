package com.api.university.service;

import com.api.university.model.Teacher;
import com.api.university.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Teacher findById(Long id){
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    public Teacher updateData(Long id, Teacher teacher){
        Teacher teacherToUpdate = findById(id);
        if(teacherToUpdate!=null){

            teacherToUpdate.setName(teacher.getName());
            teacherToUpdate.setLastName(teacher.getLastName());
            teacherToUpdate.setEmail(teacher.getEmail());
            teacherToUpdate.setInstitutionalEmail(teacher.getInstitutionalEmail());
            teacherToUpdate.setDegree(teacher.getDegree());
            return teacherRepository.save(teacherToUpdate);
        }else{
            return null;
        }
    }
}
