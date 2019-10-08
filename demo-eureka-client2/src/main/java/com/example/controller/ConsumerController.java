package com.example.controller;

import com.example.feign.TestFeignClient;
import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * Created by Ray on 2019-10-06
 */
@RestController
public class ConsumerController {
//    @Autowired
//    private RequestTemplate requestTemplate;
    private Logger logger= LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    private TestFeignClient testFeignClient;
    @RequestMapping("/testlogin/{id}")
    public String testLogin(@PathVariable String id){
        System.out.println("-----------------------------");
        logger.debug("==============={}",id);
        return testFeignClient.login(id);
    }

    @RequestMapping("/regist")
    public String testRegist(User user){
        System.out.println("consumer---"+user.getUsername()+"=="+user.getPassword());
        return testFeignClient.regist(user);
    }
}
