package com.nhnacademey.board.controller;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.User;
import com.nhnacademey.board.domain.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(
                request.getParameter("name"),
                request.getParameter("id"),
                request.getParameter("pw")
        );

        UserRepository repository = (UserRepository) request.getServletContext().getAttribute("repository");
        repository.registUser(user);

        return "redirect:/user/view.do?id=" + user.getId();
    }
}
