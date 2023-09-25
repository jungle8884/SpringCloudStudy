package com.test.service.client;

import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author Jungle 
 * @version 2023/09/23 23:40
**/
//@FeignClient("userservice")
//fallback参数指定为我们刚刚编写的实现类
// OpenFeign 实现服务降级
@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {

    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid") int uid);  //参数和返回值也保持一致
}

