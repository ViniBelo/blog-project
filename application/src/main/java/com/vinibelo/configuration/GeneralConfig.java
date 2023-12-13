package com.vinibelo.configuration;

import com.vinibelo.repository.PostStub;
import com.vinibelo.repository.SubjectStub;
import com.vinibelo.repository.UserStub;
import com.vinibelo.service.SubjectService;
import domain.Post;
import domain.Subject;
import domain.user.Role;
import domain.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class GeneralConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        var user1 = new User(UUID.randomUUID(), "Vinicius", Role.ADMINISTRATOR);
        var user2 = new User(UUID.randomUUID(), "Felipe", Role.COMMON);
        var userStub = new UserStub();
        userStub.saveUser(user1);
        userStub.saveUser(user2);

        var subject1 = new Subject(UUID.randomUUID(), "Title 1", new ArrayList<>());
        subjectStub().saveSubject(subject1);

        var post1 = new Post(UUID.randomUUID(), user1, "Esse post é um teste!", Instant.now(), Instant.now());
        subject1.getPosts().add(post1);

        var post2 = new Post(UUID.randomUUID(), user2, "Esse post é outro teste!", Instant.now(), Instant.now());
        subject1.getPosts().add(post2);
    }


    @Bean
    public SubjectStub subjectStub() {
        return new SubjectStub();
    }

    @Bean
    public PostStub postStub() {
        return new PostStub();
    }

    @Bean
    public SubjectService subjectService() {
        return new SubjectService(subjectStub(), postStub());
    }
}
