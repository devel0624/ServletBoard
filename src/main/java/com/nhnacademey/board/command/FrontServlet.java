package com.nhnacademey.board.command;

import com.nhnacademey.board.controller.UserViewController;
import com.nhnacademey.board.controller.login.LoginController;
import com.nhnacademey.board.controller.login.LoginFormController;
import com.nhnacademey.board.controller.login.LogoutController;
import com.nhnacademey.board.controller.register.UserRegisterController;
import com.nhnacademey.board.controller.register.UserRegisterFormController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("FrontServlet Processing");

        // 공통 - content 타입과 encoding 지정
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try{
            Command command  = resolveCommand(req.getServletPath(), req.getMethod());

            String view = command.execute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)){
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // redirect 가 아니라면 JSP에게 view 처리를 위임하고 결과를 include
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }

        } catch (Exception e){
            log.error("",e);
            req.setAttribute("exception",e);
            RequestDispatcher rd = req.getRequestDispatcher("/errors/error.jsp");
            rd.forward(req,resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        log.info("FrontServlet Process " + "path : " + servletPath + ", method : " + method);

        if ("/user/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserRegisterFormController();
        }else if ("/user/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserRegisterController();
        }else if("/user/login.do".equals(servletPath) && "GET".equals(method)){
            command = new LoginFormController();
        }else if("/user/login.do".equals(servletPath) && "POST".equals(method)) {
            command = new LoginController();
        }else if("/user/view.do".equals(servletPath) && "GET".equals(method)) {
            command = new UserViewController();
        }else if("/user/logout.do".equals(servletPath) && "GET".equals(method)) {
            command = new LogoutController();
        }

        return command;
    }
}
