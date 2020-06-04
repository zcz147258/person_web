package com.it.person.Controller;

import com.it.person.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/postblog")
    public Map<String,String> SaveBlog(@RequestParam("username") String username,
                                       @RequestParam("title") String title,
                                       @RequestParam("sort") String sort,
                                       @RequestParam("content") String content){
        return blogService.SaveBlog(username,title,sort,content);
    }

    @GetMapping("/getblog")
    public Map<String,Object> GetBlog(){
        return blogService.GetBlog();
    }
}
