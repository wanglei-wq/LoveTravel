package cn.kgc.service;

import cn.kgc.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface UserService {
    /**
     * 登录
     * @return
     * @throws Exception
     */
    User login(User user);
    /**
     * 注册账号密码
     * @return
     * @throws Exception
     */
    Integer saveUser(User user);
    /**
     * 根据账号和手机验证码修改密码
     * @return
     * @throws Exception
     */
    Integer updateByPhone(String phone);

    /**
     * 查询所有用户
     */
    List<User> queryAllUser();

    /**
     * 发送yzm
     * @param phone
     * @return
     */
    String getSms(String phone);

    /**
     *
     */
    User phoneLogin(String phone);

}
