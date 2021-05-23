package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Date;
import java.util.Optional;

@Controller
public class PostControl {
    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    public PostControl(PostService postService, UserService userService,
                       CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        post.setCreated(new Date(System.currentTimeMillis()));
        Optional<User> user =  userService.findByUsername((SecurityContextHolder.getContext()
                .getAuthentication().getName()));
        user.ifPresent(post::setUser);
        postService.save(post);
        return "redirect:/post?id=" + postService.findById(post.getId()).get().getId();
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post) {
        Optional<Post> postFromMem = postService.findById(post.getId());
        if (postFromMem.isPresent()) {
            postFromMem.get().setDesc(post.getDesc());
            postFromMem.get().setName(post.getName());
        }
        return "redirect:/post?id=" + post.getId();
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "/create";
    }

    @GetMapping("/load")
    public String updateLoad(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "/edit";
    }

    @GetMapping("/post")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user",
                userService.findByUsername((SecurityContextHolder.getContext().getAuthentication()
                        .getName())));
        model.addAttribute("comments", commentService.findCommentsByPostId(id));
        return "/post";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id) {
        if (postService.findById(id).isEmpty()) {
            return "redirect:/index";
        }
        postService.delete(postService.findById(id).get());
        return "redirect:/index";
    }
}
