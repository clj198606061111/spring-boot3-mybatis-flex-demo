package com.itclj.service;

import com.alibaba.fastjson2.JSON;
import com.itclj.BaseTest;
import com.itclj.entity.User;
import com.itclj.entity.table.UserTableDef;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
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

    @Test
    public void getById(){
        Integer id=21834;
        User user=userService.getById(id);
        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void deleteById(){
        Integer id=21833;
        boolean res=  userService.removeById(id);
        logger.info("res={}",res);
    }

    @Test
    public void queryPage(){
        Page<User> page=new Page<>();
        page.setPageNumber(1);
        page.setPageSize(5);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.where(UserTableDef.USER.AGE.ge(1));
        Page pageRes=  userService.page(page,wrapper);
        logger.info("pageRes={}",JSON.toJSONString(pageRes));
    }
}
