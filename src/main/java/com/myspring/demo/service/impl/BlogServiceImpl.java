package com.myspring.demo.service.impl;

import com.myspring.demo.entity.Blog;
import com.myspring.demo.mapper.BlogMapper;
import com.myspring.demo.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
