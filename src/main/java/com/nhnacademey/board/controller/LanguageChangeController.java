package com.nhnacademey.board.controller;

import com.nhnacademey.board.command.Command;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageChangeController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ServletContext servletContext = request.getServletContext();

        String lang = (String) servletContext.getAttribute("lang");

        if(lang.equals("ko")){
            servletContext.setAttribute("lang","en");
        }else {
            servletContext.setAttribute("lang","ko");
        }
        return "redirect:/";
    }
}
