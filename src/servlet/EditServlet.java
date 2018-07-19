package servlet;

import bean.UserInfoBean;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int  id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        UserInfoService service =  new UserInfoServiceImpl();
        UserInfoBean user = service.findUserInfoById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
    }
}
