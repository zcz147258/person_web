package com.it.person.Controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.it.person.Bean.User;
import com.it.person.Utils.TokenUtil;
import com.it.person.Annotation.UserLoginToken;
import com.it.person.Service.TokenService;
import com.it.person.Service.UserService;
import com.it.person.Annotation.UserLoginToken;
import com.it.person.Service.TokenService;
import com.it.person.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
            HttpServletResponse response) throws JSONException {
        Map<String,Object> map = new HashMap<>();
        User user = userService.findUserByUsername(username);
        //判断用户名是否存在
        if (user == null) {
            map.put("message", "用户不存在");
            return map;
        }else if(!password.equals(user.getPassword())){
            //检验密码
            map.put("message", "登录失败,密码错误");
            return map;
        }else {
            String token = tokenService.getToken(user);
            map.put("token", token);
            map.put("success",true);
            return map;

        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {

        // 取出token中带的用户id 进行操作
        TokenUtil.getTokenUserId();

        return "你已通过验证";
    }

}
