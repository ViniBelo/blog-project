package com.vinibelo.service;

import com.vinibelo.repository.SubjectStub;
import domain.Subject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectStub subjectStub;

    public List<Subject> listAll() {
        return subjectStub.getAll();
    }
}
