package com.nhnacademey.board.controller;

import com.nhnacademey.board.command.Command;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        log.info("login doPost");
        if(id.equals(id) && pw.equals(pw)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
        }

        return "redirect:/user/view.do?id=" + id;
    }
}
