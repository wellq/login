package service.impl;

import bean.PageBean;
import bean.UserInfoBean;
import dao.UserDao;
import service.UserInfoService;

import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {


    @Override
    public List<UserInfoBean> findAllInfo() {
        UserDao user = new UserDao();
        return user.findAllInfo();
    }

    @Override
    public UserInfoBean updateUserInfo(UserInfoBean user) {
        UserDao userDao = new UserDao();
        return userDao.updateUserInfo(user);
    }

    @Override
    public void addUser(UserInfoBean user) {
        UserDao userinfo = new UserDao();
        userinfo.addUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        UserDao user = new UserDao();
        return user.deleteUserById(id);
    }

    @Override
    public PageBean findUser(String name, String sex, int currPage) {
        UserDao user = new UserDao();
        PageBean<UserInfoBean> page = new PageBean();

        //每页显示的记录数
        int pageSize = user.PAGESIZE;
        page.setPageSize(pageSize);

        //总计录数
        int totalCount = user.findTotalCount();
        page.setTotalCount(totalCount);



        //每页显示的数据
        List<UserInfoBean> lists = user.findUser(name, sex, currPage);
        page.setLists(lists);

        //总页数
/*        int totalPage = 0;
        if (totalCount / pageSize  == 0) {
            totalPage = totalCount / pageSize;
        }
        else {
            totalPage = totalCount / pageSize + 1;
        }
        page.setTotalPage(totalPage);
        */
        //总页数
        page.setTotalPage(totalCount % pageSize==0 ? totalCount / pageSize : (totalCount / pageSize) + 1);

        return page;
    }

    @Override
    public UserInfoBean findUserInfoById(int id) {
        UserDao user = new UserDao();
        return user.findUserInfoById(id);
    }



    @Override
    public PageBean findUserByPage(int currentPage) {
        UserDao user = new UserDao();
        PageBean<UserInfoBean> page = new PageBean();

        //每页显示的记录数
        int pageSize = user.PAGESIZE;
        page.setPageSize(pageSize);

        //总计录数
        int totalCount = user.findTotalCount();
        page.setTotalCount(totalCount);

        //每页显示的数据
        List<UserInfoBean> lists = user.findPageInfo(currentPage);
        page.setLists(lists);

        //总页数
/*        int totalPage = 0;
        if (totalCount / pageSize  == 0) {
            totalPage = totalCount / pageSize;
        }
        else {
            totalPage = totalCount / pageSize + 1;
        }
        page.setTotalPage(totalPage);
        */
        //总页数
        page.setTotalPage(totalCount % pageSize==0 ? totalCount / pageSize : (totalCount / pageSize) + 1);

        return page;
    }
}
