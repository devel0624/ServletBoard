package com.nhnacademey.board.controller.login;

import com.nhnacademey.board.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if(Objects.isNull(session.getAttribute("id"))){
            return "/loginForm.jsp";
        }else {
            return "redirect:/user/view.do?id=" + session.getAttribute("id");
        }
    }
}
