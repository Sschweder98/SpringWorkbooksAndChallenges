package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
