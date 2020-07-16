package cn.kgc.service;

import org.apache.ibatis.annotations.Param;

public interface InformationService {
	//更新个人信息
    public int updateInformation(String realName, String gender, Integer uId);
    //更新新密码
    public int updatePassword(Integer uId,String oldPassword,String newPassword1,String newPassword2);
}
