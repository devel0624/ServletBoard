package com.nhnacademey.board.controller.post;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.post.ConcretePost;
import com.nhnacademey.board.domain.post.Post;
import com.nhnacademey.board.domain.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Slf4j
public class PostRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("PostRegisterController");

        ServletContext context = request.getServletContext();

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");
        Post post = new ConcretePost();

        post.setTitle(title);
        post.setContent(content);
        post.setWriteTime(LocalDateTime.now());

        HttpSession session = request.getSession(false);

        post.setWriterUserId((String) session.getAttribute("id"));

        long postId = postRepository.register(post);
        post.setId(postId);

        return "redirect:/post/view.do?id="+post.getId();
    }
}
