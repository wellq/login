package servlet;

import bean.PageBean;
import bean.UserInfoBean;
import com.sun.org.apache.xpath.internal.operations.String;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        try {
            request.setCharacterEncoding("utf-8");
            int currPage = Integer.parseInt(request.getParameter("currPage"));

            // System.out.println("dd: " + currPage);
            UserInfoService service = new UserInfoServiceImpl();
            PageBean<UserInfoBean> page = service.findUserByPage(currPage);

            request.getSession().setAttribute("totalPage", page.getTotalPage());

            page.setCurrPage(currPage);
            request.setAttribute("page", page);

            request.getRequestDispatcher("pageuserlist.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
