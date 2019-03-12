package servlet;

import entity.User;
import service.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Service service = new Service();

        User user = service.login(username, password);
        System.out.println("db:" + user);
        if (user == null) {
            resp.getWriter().write("登录失败");
            return;
        }

        resp.getWriter().write("登录成功,3秒后跳转");
        resp.sendRedirect(req.getContextPath() + "E:\\jp\\servletDemo1\\src\\main\\webapp\\refresh.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
