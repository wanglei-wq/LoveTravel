package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer rId;
    private Integer roomTypeId;
    private BigDecimal price;
    private Integer ismeal;
    private Integer peopleNum;
    private Integer hotelId;
    private Integer num;
    //房间类型
    private RoomType roomType;
}