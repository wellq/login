package util;


import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_user?characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWD ="root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn;


    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConn() {
        try {
            //1.加载驱动程序
            Class.forName(DRIVER);
            //2.获得数据库的连接
            conn=DriverManager.getConnection(URL, USERNAME, PASSWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     */
    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
