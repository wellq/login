package servlet;

import bean.PageBean;
import bean.UserInfoBean;
import dao.UserDao;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        UserInfoBean userInfoBean = new UserInfoBean(name, sex, age, phone, address);
        UserInfoService userInfoService = new UserInfoServiceImpl();
        userInfoService.addUser(userInfoBean);

        PageBean page = new PageBean();
        int lastPage = 0;
        int cpage= (int)request.getSession().getAttribute("totalPage");
        if ((page.getTotalCount()) / 5 == 0) {
            lastPage = cpage;
        }
        else {
            lastPage = cpage + 1;
        }
        System.out.println("cpage``` " + lastPage );
        response.sendRedirect("UserPageServlet?currPage=" + lastPage );
        //response.sendRedirect("UserPageServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
