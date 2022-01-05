package com.myspring.demo.mapper;

import com.myspring.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author anonymous
 * @since 2021-12-28
 */

public interface UserMapper extends BaseMapper<User> {
    User getById(Integer id);
}
