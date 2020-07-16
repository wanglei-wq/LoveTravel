package cn.kgc.service;

import cn.kgc.dao.UserMapper;
import cn.kgc.pojo.User;
import cn.kgc.util.Sendsms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User login(User user) {
        return userMapper.login(user);
    }

    /**
     * 注册账号密码
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    /**
     * 根据账号和手机验证码修改密码
     *
     * @param phone
     * @return
     * @throws Exception
     */
    public Integer updateByPhone(String phone) {
        return userMapper.updateByPhone(phone);
    }

    /**
     * 查询所有用户
     */
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public String getSms(String phone) {
        return Sendsms.getSms(phone);
    }

    /**
     * @param phone
     */
    @Override
    public User phoneLogin(String phone) {
        return userMapper.phoneLogin(phone);
    }
}

