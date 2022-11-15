package com.api.university.service;

import com.api.university.model.Student;
import com.api.university.model.Subject;
import com.api.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService{
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

    public Student updateDate(Long id, Student studentUpdated){
        Student student = findById(id);
        if(student!=null){
            student.setName(studentUpdated.getName());
            student.setLastName(studentUpdated.getLastName());
            student.setEmail(studentUpdated.getEmail());
            student.setInstitutionalEmail(studentUpdated.getInstitutionalEmail());
            return studentRepository.save(student);
        }else{
            return null;
        }
    }
    public boolean addSubject(Subject subject, Long id){
        Student student = findById(id);
        if(student!=null){
            student.addSubject(subject);
            studentRepository.save(student);
            return true;
        }else{
            return false;
        }
    }
    public Student removeSubject(Subject subject, Long id){
        Student student = findById(id);
        if(student!=null){
            student.deleteSubject(subject);
            return studentRepository.save(student);
        }else{
            return null;
        }
    }

}
