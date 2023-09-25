package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jungle
 */
@RestController
public class UserController {

    @Resource
    UserService service;

    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid,
                             HttpServletRequest request){
        System.out.println("user-我被调用拉！");
        System.out.println(request.getHeader("Jungle"));
        return service.getUserById(uid);
    }
}
