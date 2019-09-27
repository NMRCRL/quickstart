package com.login.controller;

import com.login.entity.User;
import com.login.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liu tianyuan
 * @ClassName
 * @Description 拦截 /login 请求,处理用户登录请求
 * @Date 2019/9/26
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取出请求参数
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //创建UserService对象
        UserService us=new UserService();
        //创建数据
        us.init();
        //调用登录功能，得到用户对象
        User user= us.userLogin(account,password);
        if (user!=null){
            //登陆成功将用户信息记录session页面跳转到/index进入indexServlt 获取带到首恶的数据
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("index");
        }else{
            resp.sendRedirect("/");
        }

    }
}
