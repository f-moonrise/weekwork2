package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.pojo.bo.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zangye03@gmail.com
 * @date 2020/2/10 23:17
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    显示所有人
    public List<Users> selectAll() {
        String sql = "select * from biruser where status=?";
        List<Users> li = jdbcTemplate.query(sql, new UserRowMapper(),0);
        return li;
    }

//    注册
    public int register(String username, String password) {
        String sql = "insert into biruser values(null,?,?)";
        int i = jdbcTemplate.update(sql,username,password);
        return i;
    }

//    登录
    public int login(String username, String password) {
        String sql = "select id,username,password from biruser where username = ? and password = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, username, password);

        if (maps.size() != 0){
            return 1;
        }
        return 0;
    }

//    该用户是否存在
    public int selectByUserName(String username) {

        String sql = "select username from biruser where username = ? ";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, username);

        if (maps.size() != 0){
            return 1;
        }
        return 0;
    }

    public Users selectByUserNameAndPassWord(String username, String password) {
        String sql = "select * from biruser where username = ? and password = ?";
        Users u = jdbcTemplate.queryForObject(sql,new UserRowMapper(),username,password);
        return u;
    }
}
