package com.itdr.service.impl;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/10 23:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<Users> getAll() {
        List<Users> li = userDao.selectAll();
        return li;
    }

    @Override
    public ResponseCode<Users> register(String username, String password) {
//        int i = userDao.register(username,password);
//        return 0;
        // 参数非空判断
        if (username == null || "".equals(username)){
            return ResponseCode.toDefeated("输入错误！");
        }
        if (password == null || "".equals(password)){
            return ResponseCode.toDefeated("输入错误！");
        }

        int i = userDao.selectByUserName(username);
        if (i != 0){
            return ResponseCode.toDefeated("用户名已存在！");
        }

        int i1 = userDao.register(username,password);

        // 成功则返回用户数据
        if (i1 == 0){
            return ResponseCode.toDefeated("注册失败！");
        }
        return ResponseCode.toSuccess("注册成功");
    }

    @Override
    public int addOne() {
        return 0;
    }

    @Override
    public Users login(String username, String password) {
//        参数非空判断
        if( StringUtils.isEmpty(username)){
//            错误
            return null;
        }
       if(StringUtils.isEmpty(password)){
//           错误
           return null;
       }

//       查找用户是否存在
        Users u = userDao.selectByUserNameAndPassWord(username,password);
       if (u == null){
           return null;
       }
       return  u;

    }

    @Override
    public List<Users> cc() {
//        创建空集合保存数据
        List<Users> liNew = new ArrayList<Users>();
//        查询所有好友
        List<Users> li = userDao.selectAll();
//        获取当前系统时间的日期
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.DAY_OF_MONTH);
//        遍历每个好友，看那个好友的生日是3天以内的
        for(Users users : li){
            Date birthday = users.getBirthDay();
            Calendar c2 = Calendar.getInstance();
            Date d = new Date();
            c2.setTime(d);
            int i2 = c2.get(Calendar.DAY_OF_MONTH);

//            符合条件的好友放进新集合
            if((i2-i)<=3 && (i2-i)>=0){
                liNew.add(users);
            }
        }
        return liNew;
    }


//    @Override
//    public ResponseCode<Users> login(String username,String password) {
////        int i = userDao.login(username,password);
////        return 0;
//        // 参数非空判断
//        if (username == null || "".equals(username)){
//            return ResponseCode.toDefeated("输入错误！");
//        }
//        if (password == null || "".equals(password)){
//            return ResponseCode.toDefeated("输入错误！");
//        }
//        int i = userDao.login(username,password);
//        // 如果返回值为空，说明用户不存在，也就是登陆失败
//        if (i == 0){
//            return ResponseCode.toDefeated("用户不存在！");
//        }
//        // 成功则返回用户数据
//        return ResponseCode.toSuccess("登陆成功！");
//    }

//    @Override
//    public ResponseCode addOne() {
//        return null;
//    }



}
