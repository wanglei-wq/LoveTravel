package cn.kgc.dao;

import org.apache.ibatis.annotations.Param;

public interface InformationMapper {
    //更新联系人信息
    public int updateInformation(@Param("realName") String realName,
                                 @Param("gender") String gender,
                                 @Param("uId") Integer uId);
    //更新新密码
    public int updatePassword(@Param("uId")Integer uId,
                              @Param("password")String password);
   //查询原密码
    public String queryPassword(@Param("uId")Integer uId);
}
