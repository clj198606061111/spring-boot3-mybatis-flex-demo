package com.itclj.service;

import com.alibaba.fastjson2.JSON;
import com.itclj.BaseTest;
import com.itclj.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserServiceTest extends BaseTest {

    private Logger logger= LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    UserService userService;

    @Test
    public void add(){
        User user=new User();
        user.setName("ice.chen");
        user.setAge(33);
        user.setEmail("ice.chen@itclj.com");
        userService.save(user);
        logger.info(JSON.toJSONString(user));
    }
}
