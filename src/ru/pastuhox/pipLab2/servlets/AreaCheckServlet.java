package ru.pastuhox.pipLab2.servlets;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AreaCheckServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String strY = request.getParameter("chart_y").trim();
        String strX = request.getParameter("chart_x").trim();
        String strR = request.getParameter("chart_r").trim();

        if ("".equals(strX))
        {
            strX = "not stated";
        }
        double X, Y, R;
        String greetings = "Out";

        X = Double.parseDouble(strX);
        Y = Double.parseDouble(strY);
        R = Double.parseDouble(strR);

        String timeStamp = new SimpleDateFormat("dd.MM.YY HH:mm:ss").format(Calendar.getInstance().getTime());

        // coordinates for triangle
        double A_X = 0;
        double A_Y = 0;
        double B_X = R / 2;
        double B_Y = 0;
        double C_X = 0;
        double C_Y = -R;


        if (isInSquare(X, Y, R))
            greetings = "In ";

        else if (isInCircle(X, Y, R))
            greetings = "In";
        else if (isInTriangle(A_X, A_Y, B_X, B_Y, C_X, C_Y, X, Y))
            greetings = "In";

//        Map<String, String> options = new LinkedHashMap<>();
//
//
//        options.put("time", timeStamp);
//        options.put("isIn", greetings);
//        options.put("x", strX);
//        options.put("y", strY);
//        options.put("r", strR);
//        String json = new Gson().toJson(options);

        final val result = getResult(strX, strY, strR, greetings, timeStamp);

        if (result == null) {
            return;
        }

        addResultToHistory(request, result);

//        response.setContentType("application/json");
        sendResponse(response, result);
//        response.getWriter().write(json);
    }

    private boolean isInCircle(double x, double y, double r)
    {
        return Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)
                && x <= 0 && y >= 0;
    }

    private boolean isInSquare(double x, double y, double r)
    {
        return x >= 0 && x <= (r / 2) && y >= 0 && y <= r;
    }


    private boolean isInTriangle(double A_X, double A_Y, double B_X, double B_Y, double C_X, double C_Y, double X, double Y)
    {
        double a = (A_X - X) * (B_Y - A_Y) - (B_X - A_X) * (A_Y - Y);
        double b = (B_X - X) * (C_Y - B_Y) - (C_X - B_X) * (B_Y - Y);
        double c = (C_X - X) * (A_Y - C_Y) - (A_X - C_X) * (C_Y - Y);
        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0);
    }


    private void addResultToHistory(HttpServletRequest req, AreaCheckServletResult result) {
        final val session = req.getSession();

        String historyAttribute = "history";
        synchronized (req.getSession()) {
            if (session.getAttribute(historyAttribute) == null) {
                session.setAttribute(historyAttribute, new ConcurrentLinkedQueue<AreaCheckServletResult>());
            }
        }

        final val history = (ConcurrentLinkedQueue<AreaCheckServletResult>)
                session.getAttribute(historyAttribute);


        history.add(result);
    }

    private AreaCheckServletResult getResult(String x, String y, String r, String isIn, String date) {



        return AreaCheckServletResult.builder()
                .x(x)
                .y(y)
                .r(r)
                .isIn(isIn)
                .date(date)
                .build();
    }

    @SneakyThrows
    private void sendResponse(HttpServletResponse resp, AreaCheckServletResult result) {
        resp.setContentType("application/json");
        String json = new Gson().toJson(result);
        resp.getWriter().write(json);
    }
}
