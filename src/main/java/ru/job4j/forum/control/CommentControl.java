package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Date;
import java.util.Optional;

@Controller
public class CommentControl {
    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    public CommentControl(PostService postService, CommentService commentService,
                          UserService userService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping("/saveComment")
    public String save(@ModelAttribute Comment comment, @RequestParam("id") int id) {
        comment.setCreated(new Date(System.currentTimeMillis()));
        comment.setUser(userService.findByUsername(SecurityContextHolder.getContext()
                .getAuthentication().getName()).get());
        comment.setPost(postService.findById(id).get());
        commentService.save(comment);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/deleteComment")
    public String delete(@RequestParam("id") int id) {
        Optional<Comment> comment = commentService.findById(id);
        if (comment.isEmpty()) {
            return "redirect:/index";
        }
        int postId = comment.get().getPost().getId();
        commentService.delete(comment.get());
        return "redirect:/post?id=" + postId;
    }

    @GetMapping("/comment")
    public String create(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "comment/create";
    }
}
