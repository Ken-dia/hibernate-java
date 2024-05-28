package com.samanecorp.secureapp.filter;


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

@WebFilter("/*")
public class PrivateFilter implements Filter {
    /**
     * Default constructor
     */
    public PrivateFilter() {}
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        // On recupère le nom de la session
        String username = (String) session.getAttribute("username");
        // on recupere le chemin demandé par l'utilisateur
        String chemin = request.getServletPath();
        // On recupère la methode HTTP utilisée (GET ou POST)
        String method = request.getMethod();
        if (username != null || chemin.equals("/") || chemin.equals("/login") || chemin.equals("/singup") || chemin.equals("/logout") || chemin.equals("/index.jsp") || chemin.startsWith("/public/")) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    public void destroy() {

    }

}
