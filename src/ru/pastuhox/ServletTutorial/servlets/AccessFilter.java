package ru.pastuhox.ServletTutorial.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter("/GetUserServlet")
public class AccessFilter implements Filter
{
    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws java.io.IOException, ServletException{
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (!req.getRequestURL().toString().endsWith("/GetUserServlet")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        resp.sendRedirect("index.jsp");
    }

    public void destroy() {}

    @Override
    public boolean isLoggable(LogRecord record)
    {
        return false;
    }
}