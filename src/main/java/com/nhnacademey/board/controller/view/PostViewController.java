package com.nhnacademey.board.controller.view;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.post.Post;
import com.nhnacademey.board.domain.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PostViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = request.getServletContext();

        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");

        long id = Long.parseLong(request.getParameter("id"));

        Post post = postRepository.getPost(id);

        context.setAttribute("post",post);

        return "/postView.jsp";
    }
}
