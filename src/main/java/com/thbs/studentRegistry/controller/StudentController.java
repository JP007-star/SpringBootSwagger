package com.thbs.studentRegistry.controller;
import com.thbs.studentRegistry.entity.Student;
import com.thbs.studentRegistry.exception.StudentNotFoundException;
import com.thbs.studentRegistry.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/studentApi")
public class StudentController {
    @Autowired
    StudentService studentService;

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path="/getAllStudents",produces = "application/json")
    public ResponseEntity getAllStudents(){
       LOG.info("studentList");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }



    @PostMapping(path = "/addStudent",produces = "application/json" ,consumes = "application/json")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        LOG.info("student added successfully");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
    }


    @GetMapping(path = "/getStudentById/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long studentId){
        return new ResponseEntity<Student>(studentService.findById(studentId), HttpStatus.OK);
    }


    @PutMapping(path = "/updateStudentById/{studentId}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("studentId") Long studentId,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.update(student),HttpStatus.OK);
    }


    @DeleteMapping(path = "/deleteStudentById/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("studentId") Long studentId){
        studentService.deleteById(studentId);
        return new ResponseEntity<String>("StudentId "+studentId+" is deleted",HttpStatus.OK);
    }
}
