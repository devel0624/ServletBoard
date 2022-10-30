package com.nhnacademey.board.controller;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();

        UserRepository repository = (UserRepository) servletContext.getAttribute("repository");

        String id = request.getParameter("id");

        if(repository.findUser(id)){ // repository에 유저가 있으면
            request.setAttribute("user",repository.getUser(id));
            return "/userView.jsp";
        }else {
            return "/404.jsp";
        }
    }
}
