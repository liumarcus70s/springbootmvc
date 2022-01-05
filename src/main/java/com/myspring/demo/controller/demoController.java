package com.myspring.demo.controller;

import com.myspring.demo.entity.User;
import com.myspring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class demoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    public String demo(){

        return "demo";
    }

//    @ResponseBody
//    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
//    public List<User> getInfo(){
//        List<User> userInfo = userService.getUserInfo();
//        return userInfo;
//    }

}
