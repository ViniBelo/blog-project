package com.vinibelo.controller;

import com.vinibelo.service.SubjectService;
import domain.Subject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/subject")
public class SubjectController {
    private SubjectService subjectService;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        System.out.println(subjectService.listAll());
        return ResponseEntity.ok().body(subjectService.listAll());
    }
}
