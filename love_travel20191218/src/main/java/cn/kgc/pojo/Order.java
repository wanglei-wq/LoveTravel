package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //序号
    private int oId;
    //订单编号
    private  String no;
    //入住时间和退宿时间
    private Ordertimes ordertimes;
   // 订单支付价格
   private double  money;
   //房间类型(zss)
   private Integer roomTypeId;
   private RoomType roomType;
   // 订单的房间数量
   private int roomCount;
   //订单生成时间
   private Date time;
   private int  userId;
   private  int hotelId;
   //订单状态
   private String state;
   //订单状态
   private int flag;
   //zss
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date inTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outTime;
    //订单列表
    private List<OrderList> orderList;
    //用户
    private User user;
    //房间信息
    private Room room;
    //酒店信息
    private Hotel hotel;

    public Order(String no,Double money ,Date time, int userId, int hotelId) {
        this.no = no;
        this.money=money;
        this.time = time;
        this.userId = userId;
        this.hotelId = hotelId;
    }
}
