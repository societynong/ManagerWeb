package com.mg.service;

public interface LoginService {

    User getUserByInput(String uname, String pwd);
    User getUserByUid(int uid);

}
