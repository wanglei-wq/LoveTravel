package cn.kgc.service;

import cn.kgc.dao.ContactMapper;
import cn.kgc.pojo.Contact;

import cn.kgc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactMapper contactMapper;

    /**
     * 获取对应用户所对应的联系人集合
     * @param id    用户Id
     * @return  联系人集合
     */
    public List<Contact> queryContactById(int id) {
        return contactMapper.selectContactById(id);
    }

    /**新增联系人
     * 先确认联系人表是否有此联系人，有即添加联系人关系表
     * 没有则先添加联系人信息再添加联系人关系表
     * @param map 联系人信息Contact和用户的所有信息
     * @return
     */
    public int insertContactAndUser(Map<String, Object> map) {
        Contact contact= (Contact) map.get("contact");
        int ix=contactMapper.insertContact(contact);
        System.out.println(ix==0?"数据库已有此数据":"成功添加新数据");
        String index=contactMapper.selectContactId(contact);
        if(index!=""&&index!=null){
            int num=Integer.parseInt(index);
            map.put("cId",num);
            System.out.println(map);
            return contactMapper.insertContactAndUser(map);
        }
        return 0;
    }
    /**
     * 更新联系人信息
     * 如果联系人只和你有关则修改联系人信息
     * 如果联系人不光和你有关系则先删除联系信息
     * 再增加联系人
     * 最后再添加联系信息
     * 实现动态更新联系人信息
     * @param map 包含联系人信息和用户信息（包括对应的Id）
     * @return 0 失败 非0 成功
     */
    public int updateContact(Map<String, Object> map) {
        Contact contact= (Contact) map.get("contact");
        System.out.println("联系人信息"+contact);
        User user= (User) map.get("user");
        int index=contactMapper.selectCountByContactId(contact.getCId());
        Map<String,Object>updateMap=new HashMap<String, Object>();
        updateMap.put("uId",user.getUId());
        updateMap.put("cId",contact.getCId());
        String strId=contactMapper.selectContactUserID(updateMap);
        Integer id=0;
        if(strId!=""&&strId!=null){
            id=Integer.parseInt(strId);
        }
        updateMap.put("id",id);
        if(index!=1){
            int index1= contactMapper.insertContact(contact);
            String index3=contactMapper.selectContactId(contact);
            Integer cId=0;
            if(index3!=null&&index3!=""){
                cId=Integer.parseInt(index3);
                updateMap.put("cId",cId);
            }
            int index2= contactMapper.updateContactAndUser(updateMap);
            if(index1!=0&&index2!=0){
                return 1;
            }
            return 0;
        }
        String index2=contactMapper.selectContactUserID(updateMap);
        if (index2!=""&&index2!=null){
            int index3=Integer.parseInt(index2);
            updateMap.put("id",index3);
            updateMap.put("realName",contact.getRealName());
            updateMap.put("mobile",contact.getMobile());
            return contactMapper.updateContact(updateMap);
        }
        return 0;
    }
        /**
         * 删除联系人信息
         * 若联系人至于你一个人有关则删除此联系人，及其对应的联系信息
         * 若不只和你有关则删除联系信息
         * @param map 中放的Contact与user 均只存在id
         * @return 0失败 非0 成功
         */
    public int deleteContact(Map<String, Object> map) {
        Contact contact= (Contact) map.get("contact");
        User user= (User) map.get("user");
        int index=contactMapper.selectCountByContactId(contact.getCId());
        Map<String,Object>updateMap=new HashMap<String, Object>();
        updateMap.put("uId",user.getUId());
        updateMap.put("cId",contact.getCId());
        int index1=contactMapper.deleteContactAndUserBy(updateMap);
        if(index==1){
            int index2= contactMapper.deleteContact(contact);
            if (index2!=0&&index1!=0){
                return 1;
            }
            return 0;
        }
        return index1;
    }
}
