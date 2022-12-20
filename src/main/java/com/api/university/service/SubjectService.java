package com.api.university.service;

import com.api.university.model.Course;
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

    public Subject save(Subject subject){
        return subjectRepository.save(subject);
    }
    public Subject findById(Long id){
        return subjectRepository.findById(id).orElse(null);
    }
    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }
    public Subject updateData(Long id, Subject subject){
        Subject subjectToUpdate = findById(id);
        if(subjectToUpdate!=null){
            subjectToUpdate.setName(subject.getName());
            subjectToUpdate.setDescription(subject.getDescription());
            subjectToUpdate.setNoteOne(subject.getNoteOne());
            subjectToUpdate.setNoteTwo(subject.getNoteTwo());
            subjectToUpdate.setNoteThree(subject.getNoteThree());
            subjectToUpdate.setNoteFour(subject.getNoteFour());
            return subjectRepository.save(subjectToUpdate);
        }else{
            return null;
        }
    }
    public Subject assignTeacher(Long id, Teacher teacher){
        Subject subject = findById(id);
        if(subject!=null && teacher!=null){
                subject.setTeacher(teacher);
                return subjectRepository.save(subject);
        }else{
            return null;
        }
    }

    public Subject removeTeacher(Long id, Teacher teacher){
        Subject subject = findById(id);
        if(subject!=null && teacher!=null){
            subject.setTeacher(null);
            return subjectRepository.save(subject);
        }else{
            return null;
        }
    }

    public Subject assignCourse(Long id, Course course){
        Subject subject = findById(id);
        if(subject!=null && course!=null){
                subject.setCourse(course);
                return subjectRepository.save(subject);
        }else{
            return null;
        }
    }

    public Subject removeCourse(Long id, Course course){
        Subject subject = findById(id);
        if(subject!=null && course!=null){
            subject.setCourse(null);
            return subjectRepository.save(subject);
        }else{
            return null;
        }
    }
}
