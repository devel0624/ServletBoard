package com.nhnacademey.board.controller.user;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.account.Client;
import com.nhnacademey.board.domain.account.User;
import com.nhnacademey.board.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = new Client(
                request.getParameter("name"),
                request.getParameter("id"),
                request.getParameter("pw")
        );

        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");
        userRepository.add(user);

        log.info("Register Success : " + user.getId());

        request.getSession().setAttribute("id",user.getId());

        return "redirect:/user/view.do?id=" + user.getId();
    }
}
