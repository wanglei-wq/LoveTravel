package cn.kgc.dao;

import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Order;

import java.util.List;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface OrderMapper {
    //查询所有订单
    List<Order> queryAllOrder(Order order);
    //查询订单详情
    Order queryOrderById(Integer id);
    //订单的删除
    Integer deleteOrderById(Integer id);
    //查询hotel.* by hId
    Hotel queryHotelNameById(Integer id);
    /**
     *查询购物车选中购物车的商品，生成订单，跳到支付界面进行支付
     */
    Integer optionProductsAddOrderAndCheckOut(Order order);
    Order selectOrderByOrderId(String no);
}
