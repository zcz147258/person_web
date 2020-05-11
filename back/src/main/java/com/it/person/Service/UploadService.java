package com.it.person.Service;

import com.it.person.Mapper.UploadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UploadService {
    @Autowired
    UploadMapper uploadMapper;
    Map<String,Object> map = new HashMap<>();
    public Map<String,Object> Upload(MultipartFile file,String username){
        if(file.isEmpty()){
            map.put("err","不能上传空信息");
            return map;
        }
        String fileName = file.getOriginalFilename();
        Integer size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "/root/jar/person_web/uploadtest" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        //判断文件后缀
        Integer last = fileName.lastIndexOf('.');
        String dotname = fileName.substring(last+1);
        System.out.println(dotname);
        //只能捕获后缀为html | mp4 | exe | zip | jpg |png |
        //存入数据库
        //定义正则表达式
        String regEx = "^((html)|(mp4)|(exe)|(zip)|(jpg)|(png))$";
        //编译成为正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dotname);
        boolean rs = matcher.matches();
        System.out.println(rs);
        if(rs){
            //System.out.println("正则校验成功");
            map.put("regEX",true);
        }else {
            //System.out.println("正则校验失败");
            map.put("regEX",false);
            return map;
        }
        try {
            uploadMapper.Upload(fileName,username,dotname,size);
        }catch (Exception e){
            map.put("exception",e);
        }
        //创建目录
        File checkexits = new File("/root/jar/person_web/uploadtest/"+dotname+"/");
        System.out.println(checkexits.exists());
        if(checkexits.exists()){
            //System.out.println("存在目录");
        }else {
            checkexits.mkdir();
        }
        File cunchu = new File("/root/jar/person_web/uploadtest/"+dotname+"/"+fileName);

        try {
            file.transferTo(cunchu); //保存文件
            map.put("success","上传成功");
            return map;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("err","上传错误");
            return map;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("err","上传错误");
            return map;
        }
    }
}
