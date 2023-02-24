package com.lpy.thread.Controller;

import com.lpy.thread.persistence.User;
import com.lpy.thread.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public String addUser(User user){
        long  start = System.currentTimeMillis();
        userService.insert(user);
        long end = System.currentTimeMillis();
        return "SUCCESS"+(end - start);
    }
}
