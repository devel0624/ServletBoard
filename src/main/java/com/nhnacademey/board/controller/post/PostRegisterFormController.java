package com.nhnacademey.board.controller.post;

import com.nhnacademey.board.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/postRegisterForm.jsp";
    }
}
