package domain;

import domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Subject {
    private UUID id;
    private String title;
    private List<Post> posts;

    public Subject(String title, List<Post> posts) {
        this.title = title;
        this.posts = posts;
    }
}
