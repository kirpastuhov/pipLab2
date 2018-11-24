package ru.pastuhox.ServletTutorial.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean check = false;

        String strY = request.getParameter("chart_y").trim();
        String strX = request.getParameter("chart_x").trim();
        String strR = request.getParameter("chart_r").trim();

        double X, Y, R;


        try
        {
            X = Double.parseDouble(strX);
            Y = Double.parseDouble(strY);
            R = Double.parseDouble(strR);
            check = true;
        }
        catch (NumberFormatException ignored)
        {

        }




        RequestDispatcher requestDispatcher;
        if (check) {
            requestDispatcher = request.getRequestDispatcher("GetUserServlet");
        }
        else {
            requestDispatcher = request.getRequestDispatcher("index.jsp");
        }
        requestDispatcher.forward(request, response);
    }
}
