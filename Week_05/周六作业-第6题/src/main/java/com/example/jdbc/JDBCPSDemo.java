package com.example.jdbc;

import java.sql.*;

/**
 * @author wangtingting
 * @date 2020-11-18 17:04
 * -------------------------------------------------------------------------
 * 使用事务，PrepareStatement 方式，批处理方式，改进上述操作。
 * -------------------------------------------------------------------------
 */
public class JDBCPSDemo {
    private static final String url = "jdbc:sqlserver://localhost:5001;DatabaseName=test";
    private static final String userName = "root";
    private static final String password = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            //设置是否自动提交事务
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args)  {

        //查询
        String querySql = "select * from sys_role where id = ?";
        String updateSql = "update sys_role set name = ? where id = ?";
        String insertSql = "insert into sys_role (id,name) values(?,?)";
        String deleteSql = "delete from sys_role  where id = ?";
        Connection connection= getConnection();
        try {
            //查询
            PreparedStatement queryPS = connection.prepareStatement(querySql);
            queryPS.setString(1,"1");
            ResultSet resultSet = queryPS.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID:" + resultSet.getString("id") + "\t" + "Name:"
                        + resultSet.getString("name"));
            }
            //插入
            PreparedStatement insertPS = connection.prepareStatement(insertSql);
            insertPS.setString(1,"7");
            insertPS.setString(2,"yyy");
            insertPS.executeUpdate();
            //更新
            PreparedStatement updatePS = connection.prepareStatement(updateSql);
            updatePS.setString(1,"rrrr");
            updatePS.setString(2,"6");
            updatePS.executeUpdate();

            //删除
            PreparedStatement deletePS = connection.prepareStatement(deleteSql);
            deletePS.setString(1,"7");
            deletePS.executeUpdate();
            //提交事务
            connection.commit();
            updatePS.close();
            insertPS.close();
            deletePS.close();
            connection.close();
        } catch (SQLException e) {
            if(connection != null){
                try {
                    //发生异常回滚
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }





    }

}
