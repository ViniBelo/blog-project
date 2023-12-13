package dto;

import domain.Post;

import java.util.List;

public record SubjectRequestDTO(String title, List<Post> posts) {
}
