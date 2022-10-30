package com.nhnacademey.board.fillter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@WebFilter(filterName = "loginFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "excludedUrls", value = "/\n" +
                "/user/login.do\n" +
                "/lang/change.do\n" +
                "/user/register.do\n" +
                "/index.jsp\n")
})
public class LoginFilter implements Filter {
    List<String> excludedUrls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("excludedUrls");
        log.info("excludedUrls={}", urls);

        this.excludedUrls = Arrays.stream(urls.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        String requestUri = ((HttpServletRequest) servletRequest).getRequestURI();

        log.info("Login Filter Process, requestUri : " + requestUri);

        if (excludedUrls.contains(requestUri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

            if (Objects.isNull(session.getAttribute("id"))) {
                log.info("Session isn't existed");
                ((HttpServletResponse) servletResponse).sendRedirect("/user/login.do");
            } else {
                log.info("Session existed");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }
}
