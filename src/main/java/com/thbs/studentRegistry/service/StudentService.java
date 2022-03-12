package com.thbs.studentRegistry.service;

import com.thbs.studentRegistry.entity.Student;
import com.thbs.studentRegistry.exception.StudentAlreadyExistException;
import com.thbs.studentRegistry.exception.StudentNotFoundException;
import com.thbs.studentRegistry.exception.StudentParameterNotFoundException;
import com.thbs.studentRegistry.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public List<Student> findAll() {
        LOG.info("findAll");
        return studentRepository.findAll();
    }


    public void deleteById(Long aLong) {
        LOG.info("deleteById");
        studentRepository.deleteById(aLong);
    }


    public Student save(Student student) {
        LOG.info("save");
        if(student.getStudentId() ==null||student.getStudentName()==null || student.getStudentAge()==null || student.getStudentFee()==null) {
            throw new StudentParameterNotFoundException("601", "Invalid Input Parameters");
        }
        else if (studentRepository.existsById(student.getStudentId())) {
            throw new StudentAlreadyExistException("409","Student Already Exist");
        }
        else {
            return studentRepository.save(student);
        }

    }

    public Student update(Student student) {
        LOG.info("save");
        if(student.getStudentName()==null || student.getStudentAge()==null || student.getStudentFee()==null) {
            throw new StudentParameterNotFoundException("601", "Invalid Input Parameters");
        }
        else {
            return studentRepository.save(student);
        }

    }



    public Student findById(Long studentId)  {
        LOG.info("findById");
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent())
            return studentOptional.get();
        throw new StudentNotFoundException("404","Student Not Found");
    }





}
