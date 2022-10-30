package com.nhnacademey.board.controller.login;

import com.nhnacademey.board.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LogoutController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if(Objects.nonNull(session.getAttribute("id"))){ // 세션에 id 가 있으면 삭제
            session.removeAttribute("id");
        }
        return "/loginForm.jsp";
    }
}
