package cn.kgc.service;


import cn.kgc.dao.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public int updateInformation(String realName, String gender, Integer uId) {
        return informationMapper.updateInformation(realName,gender,uId);
    }

    @Override
    public int updatePassword(Integer uId, String oldPassword, String newPassword1, String newPassword2) {
       if(!newPassword1.equals(newPassword2)){
           return 0;
       }
       //String oldPassword1=informationMapper.queryPassword(uId);
       return informationMapper.updatePassword(uId,newPassword1);
    }
}
