package com.bootapi.bootrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapi.bootrestapi.entities.Student;
import com.bootapi.bootrestapi.service.StudentService;

@RestController
public class PageController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student") 
    public ResponseEntity<List<Student>> getAllStu() {
        List<Student> L1 = studentService.getAllStudent();
        if (L1.isEmpty() == true) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(L1));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {

        Student s1 = this.studentService.getStuById(id);
        if (s1 == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(s1));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStu(@RequestBody Student newStudent) {

        Student finalStu = null;
        try {
            finalStu = studentService.addData(newStudent);
            System.out.println(finalStu);
            return ResponseEntity.ok().body(finalStu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStu(@PathVariable("id") int stuId) {

        try {
            studentService.deleteStu(stuId);
            
            System.out.println("Delete Successfuly..!");
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();

    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updataData(@PathVariable("id") int id, @RequestBody Student student) {

        try {
            studentService.updaStudent(student, id);
            System.out.println("Update Successfuly..!");
            return ResponseEntity.ok().body(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
