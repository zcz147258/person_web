package com.it.person.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Mapper
@Repository
public interface UploadMapper {
    @Insert("INSERT INTO upload(filename,username,type,size) VALUES(#{filename},#{username},#{type},#{size})")
    public void Upload(@Param("filename") String filename,@Param("username") String username,@Param("type") String type, @Param("size")Integer size);
}
