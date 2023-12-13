package com.vinibelo.api.subject;

import com.vinibelo.service.SubjectService;
import domain.Subject;
import dto.SubjectRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/subject")
public class SubjectController {
    private SubjectService subjectService;

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.ok().body(subjectService.listAll());
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> createNewSubject(@RequestBody SubjectRequestDTO subjectRequestDTO) {
        try {
            subjectService.createNewSubject(subjectRequestDTO);
            return ResponseEntity.ok("Subject created successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> renameSubject(@PathVariable UUID id, @RequestBody SubjectRequestDTO subjectRequestDTO) {
        try {
            subjectService.renameSubject(id, subjectRequestDTO);
            return ResponseEntity.ok("Subject renamed successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<?> deleteSubject(@PathVariable UUID id) {
        try {
            subjectService.deleteSubject(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
