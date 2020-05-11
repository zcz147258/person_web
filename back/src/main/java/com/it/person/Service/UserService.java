package com.it.person.Service;

import com.it.person.Bean.User;
import com.it.person.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    //token检验根据id检验
    public User findUserById(Integer id){
        User user = userMapper.findUserById(id);
        if (user == null){
            return null;
        }else {
            return user;
        }
    }
    //查询用户
    public User findUserByUsername(String username){
        return userMapper.findUserByUsername(username);
    }

}
