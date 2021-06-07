package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query(value = "select * from post where id = (select post_id from comment where id=:id)",
            nativeQuery = true)
    Optional<Post> findPostByCommentId(int id);
}
