package com.mg.dao;

import com.mg.service.User;

public interface LoginDao {
    String url = "jdbc:mysql://localhost:3306/zyndb";
    User getUserbyInput(String uname, String pwd);
    User getUserbyUid(int uid);
}
