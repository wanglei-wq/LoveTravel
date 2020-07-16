package cn.kgc.service;

import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Order;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface OrderService {
    //查询所有订单
    PageInfo<Order> queryAllOrder(Order order, Integer pageNum, Integer pageSize);
    //查询订单详情
    Order queryOrderById(Integer id);
    //订单的删除
    Integer deleteOrderById(Integer id);
    //查询酒店详细信息byid
    Hotel queryHotelNameById(Integer id);
    /**
     *查询购物车选中购物车的商品，生成订单，跳到支付界面进行支付
     */
    Order optionProductsAddOrderAndCheckOut(Order order);
    Order selectOrderByOrderId(String no);
}
