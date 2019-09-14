package com.mg.servlet;

import com.mg.service.LoginService;
import com.mg.service.User;
import com.mg.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServiceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        LoginService ls = new LoginServiceImpl();

        User user = ls.getUserByInput(uname,pwd);

        if(user == null)
            resp.sendRedirect("/mg");
        else {
            Cookie ck = new Cookie("uid",String.valueOf(user.getUid()));
            ck.setPath("/mg");
            ck.setMaxAge(15);
            resp.addCookie(ck);

            req.setAttribute("uname",uname);
            req.getRequestDispatcher("main.jsp").forward(req,resp);
        }
    }
}
