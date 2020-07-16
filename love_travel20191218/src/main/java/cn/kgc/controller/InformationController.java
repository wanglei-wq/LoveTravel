package cn.kgc.controller;

import cn.kgc.pojo.Contact;
import cn.kgc.pojo.User;
import cn.kgc.service.ContactService;
import cn.kgc.service.InformationService;
import cn.kgc.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;
    @RequestMapping(value = "update",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(@RequestParam("uId")Integer uId,
                         @RequestParam("realName") String realName,
                         @RequestParam("gender") String  gender,
                         @RequestParam("mobile") String mobile,
                         @RequestParam("password") String password){
       int i= informationService.updateInformation(realName,gender,uId);
       Map<String,Object> map = new HashMap();
        map.put("uId", uId);
        Contact contact = new Contact();
        contact.setRealName(realName);
        contact.setMobile(mobile);
        map.put("contact", contact);
        int i1 = contactService.insertContactAndUser(map);
        User user=new User();
        user.setMobile(mobile);
        user.setPassword(password);
        User login = userService.login(user);
        if (i>0 && i1>0){
            return JSON.toJSONString(login);
        }else {
            return JSON.toJSONString("failed");
        }
}
    @RequestMapping(value = "updatePassword",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updatePassword(@RequestParam("uId") Integer uId,
                                 @RequestParam("password")String newPassword1,
                                 @RequestParam("mobile") String mobile){
        int i= informationService.updatePassword(uId,"333",newPassword1,newPassword1);
        if (i>0){
            User user=new User();
            user.setMobile(mobile);
            user.setPassword(newPassword1);
            User login = userService.login(user);
            return JSON.toJSONString(login);
        }else {
            return JSON.toJSONString("failed");
        }
    }
}
