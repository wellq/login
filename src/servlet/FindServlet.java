package servlet;

import bean.PageBean;
import bean.UserInfoBean;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("uname");
            String sex = request.getParameter("usex");
            int currPage = Integer.parseInt(request.getParameter("currPage"));
            System.out.println(" cuuuuu111```" + currPage);

            UserInfoService userInfoService = new UserInfoServiceImpl();
            PageBean<UserInfoBean> page = userInfoService.findUser(name, sex, currPage);

            for (int i = 0; i < page.getLists().size() ; i++) {
                System.out.println(page.getLists().get(i));
            }

            page.setCurrPage(currPage);
            request.setAttribute("page", page);

            //response.sendRedirect("userlist.jsp");
            request.getRequestDispatcher("pageuserlist.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
