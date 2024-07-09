package org.jugph.bootcamp.records.records;

import java.time.LocalDateTime;

/*
    Instruction for a Post Record
    Objective:
    Create a new record called Post for the social media application. The Post record will represent posts made by users.
    Fields:
    content (String): The content of the post.
    author (User): The user who created the post.
    timestamp (LocalDateTime): The time when the post was created.
    Compact Constructor:
    Ensure the content is not null or blank.
    Ensure the timestamp is not in the future.
    Instance Methods:
    Add a method to check if the post contains a specific keyword.
 */

public record Post(String content, User author, LocalDateTime timestamp) {
    public Post {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
        if (timestamp == null || timestamp.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Timestamp cannot be in the future");
        }
    }

    public boolean containsKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return false;
        }
        return content.contains(keyword);
    }
}