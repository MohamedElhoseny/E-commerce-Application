/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@WebFilter(urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("admin Filter initialized");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("admin doFilter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if (session != null) {
            Object role = session.getAttribute("role");
            if (role != null) {
                if ((int) role == 1) {
                    chain.doFilter(httpRequest, httpResponse);
                } else {
                    httpResponse.sendRedirect("../client/app.jsp");
                }
            } else {
                httpResponse.sendRedirect("../client/app.jsp");
            }
        } else {
            httpResponse.sendRedirect("../client/app.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("admin Filter destroyed");
        this.filterConfig = null;
    }
}
