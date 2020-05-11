package com.it.person.Mapper;

import com.it.person.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    public User findUserByUsername(String username);

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(Integer id);
}
