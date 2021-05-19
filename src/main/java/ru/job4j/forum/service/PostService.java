package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postRepository.save(
                Post.of("Куплю авто", new GregorianCalendar(), "пробег не больше 50000")
        );
        this.postRepository.save(
                Post.of("Продам смартфон", new GregorianCalendar(), "не бит, в хорошем состоянии")
        );
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>(postRepository.findAll());
        return posts;
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }
}
