package cn.kgc.service;

import cn.kgc.dao.OrderMapper;
import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Order;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageInfo<Order> queryAllOrder(Order order,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orderList = orderMapper.queryAllOrder(order);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        return  pageInfo;
    }

    @Override
    public Order queryOrderById(Integer id) {
        return orderMapper.queryOrderById(id);
    }

    @Override
    public Integer deleteOrderById(Integer id) {
        return orderMapper.deleteOrderById(id);
    }

    @Override
    public Hotel queryHotelNameById(Integer id) {
        return orderMapper.queryHotelNameById(id);
    }
    /**
     * 查询购物车选中购物车的商品，生成订单，跳到支付界面进行支付
     */
    @Override
    public Order optionProductsAddOrderAndCheckOut(Order order) {
        // 增加订单
        int i = orderMapper.optionProductsAddOrderAndCheckOut(order);
        Order queryOrder = null;
        if (i > 0) {
            System.out.println("订单添加成功！");
            // 查询出来
            queryOrder = orderMapper.selectOrderByOrderId(order.getNo());
        }
        return queryOrder;
    }

    @Override
    public Order selectOrderByOrderId(String no) {
        return  orderMapper.selectOrderByOrderId(no);
    }

}
