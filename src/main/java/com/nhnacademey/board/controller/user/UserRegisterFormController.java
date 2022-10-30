package com.nhnacademey.board.controller.user;

import com.nhnacademey.board.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UserRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if(Objects.isNull(session.getAttribute("id"))){
            return "/userRegisterForm.jsp";
        }else {
            return "redirect:/user/view.do?id=" + session.getAttribute("id");
        }

    }
}
