package com.it.person.Controller;

import com.it.person.Annotation.UserLoginToken;
import com.it.person.Service.GetinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetInfoController {
    @Autowired
    GetinfoService getinfoService;
    @UserLoginToken
    @GetMapping("/getinfo")
    public Map<String,Object> findAll(@RequestParam("username") String username,
                                      @RequestParam("type") String type){
        return getinfoService.findInfo(username,type);
    }
}
