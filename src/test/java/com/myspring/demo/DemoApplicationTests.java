package com.myspring.demo;

import com.myspring.demo.entity.User;
import com.myspring.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.getById(1);


            System.out.println(user);



    }

}
