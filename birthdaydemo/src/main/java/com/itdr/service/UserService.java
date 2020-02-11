package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import java.util.List;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/10 23:15
 */
public interface UserService {
    List<Users> getAll();

    ResponseCode<Users> register(String username, String password);

//    ResponseCode<Users> login(String username,String password);

//    ResponseCode addOne();

    int addOne();

    Users login(String username,String password);

    List<Users> cc();
}
