package dao;

import bean.PageBean;
import bean.UserBean;
import bean.UserInfoBean;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public final  int PAGESIZE = 5;

    public UserBean checkLogin(UserBean user) {
        conn = DBUtil.getConn();
        String sql = "select username, password from user where username = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return null;
    }

    /**
     * 查询数据总数量
     * @return
     */
    public  int findTotalCount() {
        conn = DBUtil.getConn();
        String sql = "select count(*) from user_info";
        int rowcount = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rowcount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return rowcount;
    }

    public List<UserInfoBean> findAllInfo() {
        List<UserInfoBean> list = new ArrayList<>();
        conn = DBUtil.getConn();
        String sql = "select * from user_info";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserInfoBean info = new UserInfoBean(rs.getInt(1),
                                                     rs.getString(2),
                                                     rs.getString(3),
                                                     rs.getInt(4),
                                                     rs.getString(5),
                                                     rs.getString(6));
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 分页显示
     * @param currPage
     * @return
     */
    public List<UserInfoBean> findPageInfo(int currPage) {
         /**
          * currPage =
         * 0   5
         * 5   5
         * 10  5
         * start = (currPage -1) * pageSize
         */
        List<UserInfoBean> list = new ArrayList<>();
        conn = DBUtil.getConn();
        String sql = "select * from user_info limit ?, ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (currPage -1) * PAGESIZE);
            ps.setInt(2, PAGESIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserInfoBean info = new UserInfoBean(rs.getInt(1),
                                                     rs.getString(2),
                                                     rs.getString(3),
                                                     rs.getInt(4),
                                                     rs.getString(5),
                                                     rs.getString(6));
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return list;
    }

    /**
     * 通过id查询一条信息
     */
    public UserInfoBean findUserInfoById(int id) {
        conn = DBUtil.getConn();
        String sql = "select * from user_info where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserInfoBean user = new UserInfoBean(rs.getInt(1),
                                                    rs.getString(2),
                                                    rs.getString(3),
                                                    rs.getInt(4),
                                                    rs.getString(5),
                                                    rs.getString(6));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return null;
    }
    /**
     * 更新信息
     */
    public UserInfoBean updateUserInfo(UserInfoBean user) {
        conn = DBUtil.getConn();
        String sql = "update user_info set name = ?, sex = ?, age = ?, phone =?, address = ? where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSex());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return null;
    }
    /**
     * 通过ID删除信息
     */
    public int deleteUserById(int id) {
        conn = DBUtil.getConn();
        String sql = "delete from user_info where id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return -1;
    }

    /**
     * 添加用户
     */
    public void addUser(UserInfoBean user) {
        conn = DBUtil.getConn();
        String sql = "insert into user_info (name, sex, age, phone, address) values (?, ?, ? , ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSex());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
    }

    /**
     * 分页查询 通过姓名或性别 模糊查询
     */
    public List<UserInfoBean> findUser(String name, String sex, int currPage) {
        List<UserInfoBean> list = new ArrayList<>();
        conn = DBUtil.getConn();
        StringBuilder sb = new StringBuilder("select * from user_info where 1=1 ");
        if (name != null && name != "") {
            sb.append("and name like '%" + name + "%'");
        }
        if (sex != null && sex != "") {
            sb.append("and sex like '%" + sex + "%'");
        }
        sb.append("limit ?, ?");

        try {
            ps = conn.prepareStatement(sb.toString());
            ps.setInt(1, (currPage -1) * PAGESIZE);
            ps.setInt(2, PAGESIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserInfoBean info = new UserInfoBean(rs.getInt(1),
                                                     rs.getString(2),
                                                     rs.getString(3),
                                                     rs.getInt(4),
                                                     rs.getString(5),
                                                     rs.getString(6));
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return list;
    }
}



