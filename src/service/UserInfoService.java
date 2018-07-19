package service;

import bean.PageBean;
import bean.UserInfoBean;

import java.util.List;

public interface UserInfoService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfoBean> findAllInfo();

    /**
     * 通过id查询一条信息
     */
    UserInfoBean findUserInfoById(int id);

    /**
     * 更新信息
     */
    UserInfoBean updateUserInfo(UserInfoBean user);

    /**
     * 通过ID删除信息
     */
    int deleteUserById(int id);

    /**
     * 添加用户
     */
    void addUser(UserInfoBean user);

    /**
     * 通过姓名或性别 模糊查询
     */
    PageBean findUser(String name, String sex, int currPage);

    /**
     * 分页显示某一页
     */
    PageBean findUserByPage(int currentPage);
}
