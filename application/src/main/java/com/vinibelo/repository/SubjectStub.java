package com.vinibelo.repository;

import domain.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SubjectStub {
    private final Map<UUID, Subject> subjects = new HashMap<>();

    public void saveSubject(Subject subject) {
        subjects.put(subject.getId(), subject);
    }

    public List<Subject> getAll() {
        return subjects.values().stream().toList();
    }
}
