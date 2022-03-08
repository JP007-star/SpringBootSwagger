package com.thbs.studentRegistry.controller;


import com.thbs.studentRegistry.entity.Student;
import com.thbs.studentRegistry.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/studentApi")
public class StudentController {
    @Autowired
    StudentService studentService;

    //This function is used fetch All Students data
    @GetMapping(path="/fetchStudents",produces = "application/json")
    public List<Student> fetchAllStudents(){
        return studentService.findAll();
    }

    // This function is used to save  the student
    @PostMapping(path = "/addStudent",produces = "application/json" ,consumes = "application/json")
    public Student addStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    //This function is used to fetch student data by id
    @GetMapping(path = "/getStudentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId){
        return studentService.findById(studentId).orElse(null);
    }

    //This function is used to update the student data
    @PutMapping(path = "/updateStudentById/{studentId}")
    public Student updateStudentById(@PathVariable("studentId") Long studentId,@RequestBody Student student){
        return studentService.save(student);
    }

    //This function is used to delete student data by id
    @DeleteMapping(path = "/deleteStudentById/{studentId}")
    public String deleteStudentById(@PathVariable("studentId") Long studentId){
        studentService.deleteById(studentId);
        return "StudentId "+studentId+" is deleted";
    }
}
