package cn.kgc.dao;

import cn.kgc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface UserMapper {
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
     *查询所有用户
     */
    List<User> queryAllUser();

    /**
     * 手机号登陆
     */
    User phoneLogin(@Param("phone") String phone);
}
