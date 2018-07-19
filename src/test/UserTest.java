package test;

import bean.PageBean;
import bean.UserInfoBean;
import dao.UserDao;
import org.junit.Test;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {

    }

    @Test
    public void findCount() {
        UserDao user = new UserDao();
        int count = user.findTotalCount();
        System.out.println(count);
    }

    @Test
    public void findAll() {
        UserInfoService userInfoService = new UserInfoServiceImpl();
        List<UserInfoBean> list = userInfoService.findAllInfo();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void findUserById() {
        UserInfoService userInfoService = new UserInfoServiceImpl();
        UserInfoBean info = userInfoService.findUserInfoById(2);
        System.out.println(info.toString());
    }

    @Test
    public void findUser() {
        UserInfoService userInfoService = new UserInfoServiceImpl();
        PageBean list = userInfoService.findUser("明", "男", 1);
    }

    @Test
    public  void findPage() {
        UserDao user = new UserDao();
        List<UserInfoBean> list = user.findPageInfo(1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

