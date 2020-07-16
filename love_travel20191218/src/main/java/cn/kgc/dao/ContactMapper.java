package cn.kgc.dao;

import cn.kgc.pojo.Contact;
import cn.kgc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ContactMapper {
    //
    public int  updateContactAndUser(Map<String,Object>map);
    //通过id查询对应的联系人
    public List<Contact> selectContactById(int uid);
    //新增不重复的联系人
    public int insertContact(Contact contact);
    //新增用户关系
    public int insertContactAndUser(Map<String,Object> map);
    //查询联系人Id
    public String selectContactId(Contact contact);
    //查询自己的Id
    public String selectUserId(User user);
    //查询联系人是否唯一
    public Integer selectCountByContactId(Integer id);
    //更改为唯一的联系人信息,非唯一的联系人信息，采用删除此条联系数据，然后新增对应联系人，再新增联系数据
    public int updateContact(Map<String,Object>map);
    //删除此条联系数据
    public int deleteContactAndUserBy(Map<String,Object>map);
    //删除联系人数据
    public int deleteContact(Contact contact);
    //查询联系数据的id
    public String selectContactUserID(Map<String,Object>map);
}
