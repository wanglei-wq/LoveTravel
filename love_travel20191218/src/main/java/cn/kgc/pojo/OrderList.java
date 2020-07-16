package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
    private Integer olId;
    private Integer orderId;
    private Integer roomId;
    private Integer contactId;
    //房间
    private Room room;
    //用户
    private User user;
    private Contact contact;
}
