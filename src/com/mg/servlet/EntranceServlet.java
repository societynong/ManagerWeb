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

public class EntranceServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cks = req.getCookies();
        if(cks != null) {
            LoginService ls = new LoginServiceImpl();

            for(int i = 0 ; i < cks.length ; ++i)
                if("uid".equals(cks[i].getName())) {
                    req.setAttribute("uname",ls.getUserByUid(Integer.parseInt(cks[i].getValue())).getUname());
                    req.getRequestDispatcher("main.jsp").forward(req,resp);
                    return;
                }

        }

        resp.sendRedirect("login.jsp");
    }
}
