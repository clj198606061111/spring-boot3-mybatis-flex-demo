package com.itclj.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.itclj.entity.User;
import com.itclj.mapper.UserMapper;
import com.itclj.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author wujia
 * @since 2024-11-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
