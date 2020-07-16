package cn.kgc.controller;

import cn.kgc.pojo.User;
import cn.kgc.service.UserService;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "loginAndRegister";
    }
    //登录
    @RequestMapping(value = "login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest request, HttpSession session){

        String mobile = request.getParameter("userPhone");
        String password = request.getParameter("userPassword");
        // System.out.println(mobile+"-------------"+password);
        User user=new User();
        user.setMobile(mobile);
        user.setPassword(password);
        User userLog=userService.login(user);
        if (null != userLog) {
            System.out.println("登录成功");
            session.setAttribute("userLog", userLog);
            return JSON.toJSONString(userLog);
        }
        //model.addAttribute("msg", "用户名或者密码错误");
        return "0";
    }
    //用户注册
    @RequestMapping("save")
    @ResponseBody
    public String saveUser(HttpServletRequest request,HttpSession session){
        String rePhone = request.getParameter("rePhone");
        String rePassword = request.getParameter("rePassword");
        User addUser=new User();
        addUser.setMobile(rePhone);
        addUser.setPassword(rePassword);
        Integer saveUser=userService.saveUser(addUser);
        if(saveUser!=null){
            //注册成功
            session.setAttribute("saveUser",saveUser);
            return "1";
        }
        // model.addAttribute("msg","这个账号已经存在");
        return "0";
    }
    //发送验证码
    @ResponseBody
    @RequestMapping(value = "yzm",produces = "application/json;charset=utf-8")
    public String getThisSms(@RequestParam("phone") String phone){
        String sms = userService.getSms(phone);
        //Integer sms = aotuYzm();
        System.out.println(phone+sms);
        return JSON.toJSONString(sms);
    }
    //测试验证码
    public Integer aotuYzm(){
        return  (int)((Math.random()*9+1)*1000);
    }
    //判断用户是否存在
    @RequestMapping("queryPhone")
    @ResponseBody
    public String isNotUser(HttpServletRequest request,Model model){
        String rePhone = request.getParameter("rePhone");
        List<User> thisUser=userService.queryAllUser();
        for (User user : thisUser) {
            if(user.getMobile().equals(rePhone)){
//                System.out.println("用户已存在");
                //用户存在
                return "0";
            }else{
                continue;
            }
        }
        return  "1";
    }
    //手机号登陆
    @ResponseBody
    @RequestMapping(value = "phoneLogin",produces = "application/json;charset=utf-8")
    public String phoneLogin(@RequestParam("phone")String phone){
        User user = new User();
        try {
            user = userService.phoneLogin(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(phone);
        if(user!=null){
            //登录成功
            return JSON.toJSONString(user);
        }
        //登录失败
        return  null;
    }
}
