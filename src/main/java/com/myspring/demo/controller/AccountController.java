package com.myspring.demo.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myspring.demo.common.dto.LoginDto;
import com.myspring.demo.common.lang.Result;
import com.myspring.demo.entity.User;
import com.myspring.demo.service.UserService;
import com.myspring.demo.util.JwtUtils;
import com.myspring.demo.util.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
@Slf4j
@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");//断言拦截
        //判断账号密码是否错误 因为是md5加密所以这里md5判断
        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            //密码不同则抛出异常
            return Result.fail("密码不正确");
        }

        String jwt = jwtUtils.generateToken(user.getId());


        //将token 放在我们的header里面
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");

        return Result.succ(MapUtil.builder()
                .put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvatar())
                .put("email",user.getEmail())
                .map()

        );
    }

    //需要认证权限才能退出登录
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        Long userId = ShiroUtil.getProfile().getId().longValue();
        //退出登录
        //log.warn(String.valueOf(userId));
        SecurityUtils.getSubject().logout();
        //SecurityUtils.getSubject();
        log.warn("y");
        return Result.succ("注销成功,ID="+String.valueOf(userId));
    }



}

