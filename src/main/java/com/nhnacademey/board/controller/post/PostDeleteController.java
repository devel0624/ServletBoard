package com.nhnacademey.board.controller.post;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.post.Post;
import com.nhnacademey.board.domain.repository.PostRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ServletContext context = request.getServletContext();

        PostRepository postRepository = (PostRepository) context.getAttribute("postRepository");

        Post post = postRepository.getPost(Long.parseLong(request.getParameter("id")));

        HttpSession session = request.getSession(false);

        String id = String.valueOf(post.getWriterUserId());
        String sessionId = (String) session.getAttribute("id");

        if (id.equals(sessionId)){
            postRepository.remove(post.getId());

            return "redirect:/post/listView.do";
        }

        return "/errors/fail.jsp";
    }
}
