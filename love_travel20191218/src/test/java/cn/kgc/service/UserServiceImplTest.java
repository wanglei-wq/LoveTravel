package cn.kgc.service;

import cn.kgc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2019/12/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    UserService userService;
    @Test
    public void test01(){
        User user = new User();
        user.setMobile("17732037217");
        user.setPassword("113322");
        User login = userService.login(user);
        System.out.println(login);
        System.out.println("");
    }
}