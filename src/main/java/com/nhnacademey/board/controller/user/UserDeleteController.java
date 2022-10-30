package com.nhnacademey.board.controller.user;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.account.Administrator;
import com.nhnacademey.board.domain.account.User;
import com.nhnacademey.board.domain.repository.UserList;
import com.nhnacademey.board.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("UserDeleteController");

        ServletContext context = request.getServletContext();
        UserRepository userRepository = (UserList) context.getAttribute("userRepository");

        String id = request.getParameter("id");

        if(userRepository.getUser(id) instanceof Administrator){
            return "redirect:/errors/adminDelete.jsp";
        }

        userRepository.remove(id);

        return "redirect:/user/login.do";
    }
}
