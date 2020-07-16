package cn.kgc.service;


import cn.kgc.pojo.Contact;
import cn.kgc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ContactServiceImplTest {
    @Autowired
    ContactService contactService;
    @Test
    public void queryContactByName() throws Exception {
       List<Contact>list= contactService.queryContactById(3);
       int i =0;
       for (Contact contact:list){
            i++;
            System.out.println("第"+i+"个联系人"+contact);
        }
    }
    @Test
    public void insertContactAndUser(){
        Map<String,Object> map=new HashMap<String, Object>();
        User user=new User();
        user.setMobile("15611555159");
        user.setPassword("123456");
        map.put("User",user);
        Contact contact=new Contact();
        contact.setRealName("王磊");
        contact.setMobile("17727732789");
        map.put("contact",contact);
        int x= contactService.insertContactAndUser(map);
        System.out.println(x==0?"数据库已有此数据":"成功添加新数据");
    }
    @Test
    public void update(){
        Map<String,Object>map=new HashMap<String, Object>();
        Contact contact=new Contact();
        contact.setCId(1);
        contact.setRealName("小强");
        contact.setMobile("17727732788");
        User user=new User();
        user.setUId(3);
//        user.setMobile("15611555159");
//        user.setPassword("123456");
        map.put("user",user);
        map.put("contact",contact);
        int index=contactService.updateContact(map);
        System.out.println(index==0?"更新失败":"更新成功");
    }
    @Test
    public void delete(){
        Map<String,Object>map=new HashMap<String, Object>();
        Contact contact=new Contact();
        contact.setCId(6);
        User user=new User();
        user.setUId(3);
        map.put("user",user);
        map.put("contact",contact);
        int index=contactService.deleteContact(map);
        System.out.println(index==0?"删除失败":"删除成功");
    }
    @Test
    public void random(){
        String randomCode = RandomStringUtil.getRandomCode(11, 2);
        System.out.println(randomCode);
    }
}
