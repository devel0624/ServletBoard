package com.nhnacademey.board.controller;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.account.User;
import com.nhnacademey.board.domain.repository.UserList;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class UserViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        log.info("UserViewControl");

        ServletContext servletContext = request.getServletContext();

        UserList repository = (UserList) servletContext.getAttribute("repository");

        String id = request.getParameter("id");

        User user = repository.getUser(id);

        if(Objects.nonNull(user)){ // repository에 유저가 있으면
            log.info("UserViewControl , Found User");
            request.setAttribute("user",user);
            return "/userView.jsp";
        }

        return "/404.jsp";
    }
}
