package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author wangtingting
 * @date 2020-11-18 17:04
 * -------------------------------------------------------------------------
 * 使用 JDBC 原生接口，实现数据库的增删改查操作。
 * -------------------------------------------------------------------------
 */
public class JDBCDemo {
    private static final String url = "jdbc:sqlserver://localhost:5001;DatabaseName=test";
    private static final String userName = "root";
    private static final String password = "123456";

    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
        //查询
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from sys_role;");
        while (rs.next()) {
            System.out.println(rs.getString("id") + " "
                    + rs.getString("name"));
        }
        //修改
        statement.executeUpdate("update sys_role set name = 'hhhh' where id = 5;");
        //删除
        statement.executeUpdate("delete from sys_role  where id = 6;");
        //添加
        statement.executeUpdate("insert into sys_role (id,name) values('6','tt')");
        statement.close();
        connection.close();
    }


}
