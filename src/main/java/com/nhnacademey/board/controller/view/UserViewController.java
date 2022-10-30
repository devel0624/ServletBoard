package com.nhnacademey.board.controller.view;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.account.User;
import com.nhnacademey.board.domain.repository.UserList;
import com.nhnacademey.board.domain.repository.UserRepository;
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

        UserRepository userRepository = (UserList) servletContext.getAttribute("userRepository");

        String id = request.getParameter("id");

        User user = userRepository.getUser(id);

        if(Objects.nonNull(user)){ // repository에 유저가 있으면
            log.info("UserViewControl , Found User");
            request.setAttribute("user",user);
            return "/userView.jsp";
        }

        return "/errors/404.jsp";
    }
}
