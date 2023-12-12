package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import domain.user.User;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Post {
    private UUID id;
    private User author;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
}
