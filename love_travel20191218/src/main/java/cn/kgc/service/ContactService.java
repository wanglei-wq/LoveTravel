package cn.kgc.service;

import cn.kgc.pojo.Contact;

import java.util.List;
import java.util.Map;

public interface ContactService {
    //通过当前用户姓名查询其对应联系人
    public List<Contact> queryContactById(int id);
    //在数据库没有此联系人信息时新增联系人
    // public int saveContact(Contact contact);
    //新增用户关系
    public int insertContactAndUser(Map<String,Object> map);
    //更新用户信息
    public int updateContact(Map<String,Object>map);
    //删除用户信息
    public int deleteContact(Map<String,Object>map);
}
