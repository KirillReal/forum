package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public Optional<Post> findPostByCommentId(int id) {
        return postRepository.findPostByCommentId(id);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
