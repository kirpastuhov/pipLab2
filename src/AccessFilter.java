import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter implements Filter
{
    public void destroy()
    {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws java.io.IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();

        if(uri.endsWith("AreaCheckServlet")){
            res.sendRedirect("index.jsp");
        }else{
            // pass the request along the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    public void init(FilterConfig config) throws ServletException
    {

    }

}
