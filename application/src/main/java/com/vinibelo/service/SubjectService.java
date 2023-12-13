package com.vinibelo.service;

import com.vinibelo.repository.PostStub;
import com.vinibelo.repository.SubjectStub;
import domain.Post;
import domain.Subject;
import dto.SubjectRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectStub subjectStub;
    private PostStub postStub;

    public void createNewSubject(SubjectRequestDTO subjectDTO) {
        var subject = new Subject(subjectDTO.title(), new ArrayList<>());
        subjectStub.saveSubject(subject);
    }

    public void deleteSubject(UUID id) {
        List<Post> posts = postStub.getAll();
        for (Post post: posts) {
            postStub.deletePost(post.getId());
        };
        subjectStub.deleteSubject(id);
    }

    public void renameSubject(UUID id, SubjectRequestDTO subjectRequestDTO) {
        var subject = new Subject(subjectRequestDTO.title(), subjectRequestDTO.posts());
        subjectStub.updateSubject(id, subject);
    }

    public List<Subject> listAll() {
        return subjectStub.getAll();
    }
}
