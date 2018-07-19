package servlet;

import bean.UserBean;
import dao.UserDao;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        UserBean user = new UserBean(name, passwd);
        //session.setAttribute("UserBean",user);
        UserDao userDao = new UserDao();
        UserBean u = userDao.checkLogin(user);
        if (u != null) {
            //response.getWriter().write("success!!!");
            response.sendRedirect("chooselist.jsp");
        }
        else {
            response.getWriter().write("fail!!!");
        }
        /*if ("aaa".equals(name) && "zzz".equals(passwd)) {
            //response.sendRedirect("success.jsp");
            response.getWriter().write("success!!!");
        }
        else {
            response.getWriter().write("fail!!!");
        }*/
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        super.doPost(request, response);
    }
}
