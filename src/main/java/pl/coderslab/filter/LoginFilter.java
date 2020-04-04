package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/app/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        Object username = httpReq.getSession().getAttribute("adminId");

        if (username == null){
            httpResp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }


    @Override
    public void destroy() {
    }
}