package com.nhnacademey.board.controller.login;

import com.nhnacademey.board.command.Command;
import com.nhnacademey.board.domain.account.User;
import com.nhnacademey.board.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Slf4j
public class LoginController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.info("login doPost");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        UserRepository userRepository = (UserRepository) request.getServletContext().getAttribute("userRepository");

        User user = userRepository.getUser(id);

        if(Objects.nonNull(user)) {
            if (user.getPassword().equals(pw)) {
                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                return "redirect:/user/view.do?id=" + id;
            } else {
                return "/errors/invalid_pw.jsp";
            }
        }else {
            return "/errors/invalid_Id.jsp";
        }
    }
}
