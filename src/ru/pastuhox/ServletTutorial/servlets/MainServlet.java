package ru.pastuhox.ServletTutorial.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


//@WebServlet("/index")
@WebServlet(name="post", urlPatterns = "/mainServlet")
public class MainServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
//        String x = req.getParameter("chart_x");
//
//        System.out.println(x);
//
////        req.setAttribute("name", "pastuhox");
////
//        req.setAttribute("x", x);
//
        req.getRequestDispatcher("index.jsp").forward(req, resp);
//
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("char_x");
        if(userName == null || "".equals(userName.trim())){
            userName = "Anonymous";
        }

        String greetings = "Hello " + userName;


        resp.setContentType("text/plain");
        resp.getWriter().write(greetings);
    }

}
