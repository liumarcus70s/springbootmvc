package com.myspring.demo.service;

import com.myspring.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anonymous
 * @since 2021-12-28
 */
public interface UserService extends IService<User> {
    User getById(Integer id);

}
