package com.api.university.service;

import com.api.university.model.Student;
import com.api.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }
    public Student findById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student updateData(Long id, Student student){
        Student studentToUpdate = findById(id);
        if(studentToUpdate!=null){
            studentToUpdate.setName(student.getName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setInstitutionalEmail(student.getInstitutionalEmail());
            return studentRepository.save(studentToUpdate);
        }else{
            return null;
        }
    }
}
