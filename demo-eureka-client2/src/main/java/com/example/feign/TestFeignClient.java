package com.example.feign;

import com.example.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * description:
 * Created by Ray on 2019-10-06
 */
@FeignClient(name = "service-provider")
public interface TestFeignClient {
    @RequestMapping("/login/{userId}")
    public String login(@PathVariable String userId);

    @RequestMapping("/regist")
    public String regist(User user);
}
