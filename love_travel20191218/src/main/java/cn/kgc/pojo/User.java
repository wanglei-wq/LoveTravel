package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/12/13.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uId;
    private String realName;
    private String gender;
    private String mobile;
    private String password;
    //联系人集合
    private Contact contact;
}