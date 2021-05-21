package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.CommentRepository;
import ru.job4j.forum.repository.PostRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void save(Comment comment) {
        Post post = postRepository.findById(comment.getPost().getId()).get();
        post.addComment(comment);
        commentRepository.save(comment);
    }
}
