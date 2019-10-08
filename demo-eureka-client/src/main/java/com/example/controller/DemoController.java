package com.example.controller;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * Created by Ray on 2019-10-06
 */
@RestController
public class DemoController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "helloworld") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
    @RequestMapping("/login/{userId}")
    public String login(@PathVariable String userId){
        return "登录成功！"+userId;
    }

    @RequestMapping("/regist")
    public String regist(@RequestBody User user){
        System.out.println("provider----"+user.getUsername()+"="+user.getPassword());
        if("tom".equals(user.getUsername())&&"1234".equals(user.getPassword())){
            return "success!!";
        }
        else {
            return "fail!!!";
        }
    }
}
