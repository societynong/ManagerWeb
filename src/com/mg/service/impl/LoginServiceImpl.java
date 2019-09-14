package com.mg.service.impl;

import com.mg.dao.LoginDao;
import com.mg.dao.impl.LoginDaoImpl;
import com.mg.service.LoginService;
import com.mg.service.User;

public class LoginServiceImpl implements LoginService {

    LoginDao ld = new LoginDaoImpl();

    @Override
    public User getUserByInput(String uname, String pwd) {
        return ld.getUserbyInput(uname,pwd);
    }

    @Override
    public User getUserByUid(int uid) {
        return ld.getUserbyUid(uid);
    }
}
