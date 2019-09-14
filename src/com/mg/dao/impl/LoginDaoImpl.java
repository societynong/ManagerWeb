package com.mg.dao.impl;

import com.mg.dao.LoginDao;
import com.mg.service.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {

    private static Connection getSqlConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,"root","1234");
        return connection;
    }
    @Override
    public User getUserbyInput(String uname, String pwd) {
        User user = null;

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,"root","1234");
            preparedStatement = connection.prepareStatement("select * from t_user where uname=? and pwd=?");
            preparedStatement.setString(1,uname );
            preparedStatement.setString(2,pwd);

            resultSet = preparedStatement.executeQuery();
            resultSet.last();

           if(resultSet.getRow() == 1 && resultSet.getString("uname").equals(uname) && resultSet.getString("pwd").equals(pwd))
               user = new User(Integer.parseInt(resultSet.getString("uid")),uname,pwd);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }

    }

    @Override
    public User getUserbyUid(int uid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = getSqlConnection();
            preparedStatement = connection.prepareStatement("select * from t_user where uid=?");
            preparedStatement.setString(1, String.valueOf(uid));
            resultSet = preparedStatement.executeQuery();
            resultSet.last();
            user = new User(Integer.parseInt(resultSet.getString("uid")),resultSet.getString("uname"),resultSet.getString("pwd"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }
    }
}
