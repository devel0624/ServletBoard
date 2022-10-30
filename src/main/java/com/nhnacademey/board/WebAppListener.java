package com.nhnacademey.board;

import com.nhnacademey.board.domain.account.Admin;
import com.nhnacademey.board.domain.post.ConcretePost;
import com.nhnacademey.board.domain.post.Post;
import com.nhnacademey.board.domain.repository.PostList;
import com.nhnacademey.board.domain.repository.PostRepository;
import com.nhnacademey.board.domain.repository.UserList;
import com.nhnacademey.board.domain.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        UserRepository userRepository = new UserList();

        userRepository.add(
                new Admin(
                        "관리자",
                        "admin",
                        "12345"
                )
        );

        PostRepository postRepository = new PostList();

        Post post = new ConcretePost();
        post.setTitle("제목");
        post.setContent("내용");
        post.setWriteTime(LocalDateTime.now());
        post.setWriterUserId("admin");

        long postId = postRepository.register(post);
        post.setId(postId);

        servletContext.setAttribute("lang","en");

        servletContext.setAttribute("userRepository", userRepository);
        servletContext.setAttribute("postRepository", postRepository);


    }
}