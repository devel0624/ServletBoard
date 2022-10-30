package com.nhnacademey.board.controller.view;

import com.nhnacademey.board.command.Command;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class PostListViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        log.info("PostListViewControl");

        return "/postListView.jsp";
    }
}
