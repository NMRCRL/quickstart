package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/login.do")
public class LoinServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决请求乱码
        req.setCharacterEncoding("UTF-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");
//        //将用户名存入request对象
//        req.setAttribute("username",username);
//        //服务器端跳转，URL地址不变
//        req.getRequestDispatcher("index.jsp").forward(req,resp);
        //获取session对象
        HttpSession session=req.getSession();
        //将用户名存入session
        session.setAttribute("username",username);
        //客户端跳转，URL变化成目标地址
        resp.sendRedirect("index.jsp");
    }
}
