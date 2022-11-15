package com.api.university.service;

import com.api.university.model.Student;
import com.api.university.model.Subject;
import com.api.university.model.Teacher;
import com.api.university.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject findById(Long id){
        return subjectRepository.findById(id).orElse(null);
    }
    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }
    public Subject save(Subject subject){
        return subjectRepository.save(subject);
    }

    public Subject updateData(Long id, Subject subjectUpdated){
            Subject subject = findById(id);
        if(subject!=null){
            subject.setId(id);
            subject.setName(subjectUpdated.getName());
            subject.setDescription(subjectUpdated.getDescription());
            return subjectRepository.save(subject);

        }else{
         return null;
        }
    }
    public Subject assignTeacher(Long id, Teacher teacher){
        Subject subject = findById(id);
        if(subject!=null){
            subject.setTeacher(teacher);
            return  subjectRepository.save(subject);
        }else{
            return null;
        }
    }

    public Subject removeTeacher(Long id){
        Subject subject = findById(id);
        if(subject!=null){
            subject.setTeacher(null);
            return subjectRepository.save(subject);
        }else{
            return null;
        }
    }
    public Subject addStudent(Long id, Student student){
        Subject subject = findById(id);
        if(subject!=null){
            subject.addStudent(student);
            return subjectRepository.save(subject);
        }else{
            return null;
        }
    }

    public Subject removeStudent(Long id, Student student){
        Subject subject = findById(id);
        if(subject!=null && student!=null){
            subject.deleteStudent(student);
            return subjectRepository.save(subject);
        }else{
            return null;
        }
    }
}
