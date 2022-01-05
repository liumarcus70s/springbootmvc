package com.myspring.demo.service.impl;

import com.myspring.demo.entity.User;
import com.myspring.demo.mapper.UserMapper;
import com.myspring.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anonymous
 * @since 2021-12-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id){
        return userMapper.getById(id);
    }
}
