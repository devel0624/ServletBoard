package com.nhnacademey.board;

import com.nhnacademey.board.domain.account.Admin;
import com.nhnacademey.board.domain.repository.UserList;
import com.nhnacademey.board.domain.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        UserRepository repository = new UserList();

        repository.add(
                new Admin(
                        "admin",
                        "관리자",
                        "12345"
                )
        );

        servletContext.setAttribute("repository", repository);


    }
}