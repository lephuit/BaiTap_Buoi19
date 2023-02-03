package com.example.demoSpring.controller;

import com.example.demoSpring.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<StudentModel> studentModels = new ArrayList<>();
    @PostMapping("")
    public ResponseEntity<List> insertByParam( @RequestParam int age, @RequestParam String name ){
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);
        studentModels.add(studentModel);
        return new ResponseEntity<>(studentModels, HttpStatus.OK);
    }
    @PostMapping("/{name}/{age}")
    public ResponseEntity<List> insertByPath( @PathVariable String name, @PathVariable int age ){
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);
        studentModels.add(studentModel);
        return new ResponseEntity<>(studentModels, HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<List> insertByBody( @RequestBody StudentModel studentModel ){
        StudentModel studentModel1 = new StudentModel();
        studentModel1.setName(studentModel.getName());
        studentModel1.setAge(studentModel.getAge());
        studentModels.add(studentModel1);
        return new ResponseEntity<>(studentModels, HttpStatus.OK);
    }
//    @PutMapping("")
//    public ResponseEntity<List> insertByBody1( @RequestBody List<StudentModel> studentModel ){
//        //@RequestBody List<StudentModel> listStudent
//        //@RequestParam("StudentModel") List<StudentModel> listStudent
//        return new ResponseEntity<>(studentModel, HttpStatus.OK);
//    }

}
