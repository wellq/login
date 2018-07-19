package servlet;

import bean.UserInfoBean;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            UserInfoService userInfoService = new UserInfoServiceImpl();
            List<UserInfoBean> list = userInfoService.findAllInfo();
//            System.out.println("daxiao:   " + list.size());
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
            request.setAttribute("list", list);
            // response.sendRedirect("userlist.jsp");
            request.getRequestDispatcher("userlist.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
