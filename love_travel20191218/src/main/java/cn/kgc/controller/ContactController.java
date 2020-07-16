package cn.kgc.controller;

import cn.kgc.pojo.Contact;
import cn.kgc.pojo.User;
import cn.kgc.service.ContactService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/21.
 */
@Controller
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "queryContact",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryContact(Integer userId) {
        List<Contact> contactList = contactService.queryContactById(userId);
        return JSON.toJSONString(contactList);
    }

    @RequestMapping(value = "updateContact",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String updateContact(Integer userId,
                                String realName,
                                String mobile,
                                Integer cId) {
        Map<String,Object> map =  new HashMap();
        User user = new User();
        user.setUId(userId);
        Contact contact = new Contact();
        contact.setCId(cId);
        contact.setMobile(mobile);
        contact.setRealName(realName);
        map.put("user", user);
        map.put("contact",contact);
        System.out.println("数据参数"+map);
        int i = contactService.updateContact(map);
        System.out.println("执行结果"+i);
        if (i>0){
            return JSON.toJSONString("update success!");
        }else {
            return JSON.toJSONString("update default!");
        }
    }

    @RequestMapping(value = "addContact",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addContact(Integer userId,String realName,String mobile) {
        Map<String,Object> map =  new HashMap();
        User user = new User();
        user.setUId(userId);
        Contact contact = new Contact();
        contact.setMobile(mobile);
        contact.setRealName(realName);
        map.put("uId",userId);
        map.put("contact",contact);
        System.out.println("数据参数"+map);
        int i = contactService.insertContactAndUser(map);
        System.out.println("执行结果"+i);
        if (i>0){
            return JSON.toJSONString("add success!");
        }else {
            return JSON.toJSONString("add default!");
        }
    }

    @RequestMapping(value = "deleteContact",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String deleteContact(Integer userId,Integer cId) {
        Map<String,Object> map =  new HashMap();
        User user = new User();
        user.setUId(userId);
        Contact contact = new Contact();
        contact.setCId(cId);
        map.put("user",user);
        map.put("contact",contact);
        System.out.println("数据参数"+map);
        int i = contactService.deleteContact(map);
        System.out.println("执行结果"+i);
        if (i>0){
            return JSON.toJSONString("delete success!");
        }else {
            return JSON.toJSONString("delete default!");
        }
    }

}
