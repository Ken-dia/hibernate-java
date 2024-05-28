package com.samanecorp.secureapp.controller;

import com.samanecorp.secureapp.dto.UserDTO;
import com.samanecorp.secureapp.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name="login", value="")
public class LoginServlet extends HttpServlet {
    private LoginService loginService;
    Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    private final String LOGIN_PAGE = "index.jsp";
    private final String HOME_PAGE = "WEB-INF/jsp/welcome.jsp";
    @Override
    public void init(ServletConfig config) throws ServletException {

        loginService = new LoginService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loadIndex(null, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Connexion methode post");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        logger.info("Tentative de connexion avec {} et {}", email, password);
        try {
            Optional<UserDTO> userDtoOption = loginService.loginUser(email,password);
            UserDTO userDto = userDtoOption.get();
            req.getSession().setAttribute("username", userDto.getEmail());
            resp.sendRedirect(HOME_PAGE);
        }  catch (Exception e) {
            String message = "informations de connexion incorrect.";
            logger.error("{}", message);
            loadIndex(message, req, resp);
        }
    }

    private void loadIndex(String message, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", message);
        req.getRequestDispatcher(LOGIN_PAGE).forward(req, resp);
    }
}
