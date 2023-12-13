package com.vinibelo.repository;

import domain.Subject;
import dto.SubjectRequestDTO;

import java.util.*;

public class SubjectStub {
    private final Map<UUID, Subject> subjects = new HashMap<>();

    public void saveSubject(Subject subject) {
        subject.setId(UUID.randomUUID());
        subjects.put(subject.getId(), subject);;
    }

    public void updateSubject(UUID id, Subject subject) {
        var persistedSubject = subjects.get(id);
        persistedSubject.setTitle(subject.getTitle());
        subjects.put(persistedSubject.getId(), persistedSubject);
    }

    public void deleteSubject(UUID id) {
        subjects.remove(id);
    }

    public List<Subject> getAll() {
        return subjects.values().stream().toList();
    }
}
