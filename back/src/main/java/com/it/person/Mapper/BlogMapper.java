package com.it.person.Mapper;

import com.it.person.Bean.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface BlogMapper {
    @Insert("INSERT INTO blog(username,blog_title,blog_sort,blog_content,create_time)" +
            "VALUES(#{username},#{title},#{sort},#{content},NOW())")
    public void SaveBlog(String username,String title,String sort,String content);

    @Select("SELECT * FROM blog")
    public ArrayList<Blog> GetBlog();
}
