package cn.kgc.dao;

import cn.kgc.pojo.AlipayOrder;
import cn.kgc.pojo.Order;
import cn.kgc.pojo.OrderList;
import cn.kgc.pojo.Room;

public interface AlipayMapper {
	/**
	 * 添加交易订单信息
	 */
	Integer addAlipayOrder(AlipayOrder alipayOrder);
	/**
	 *  修改订单的状态
	 */
	Integer updateOrderStateByOrderId(String no);

	//修改订单入住的离职时间，订单金额，房间类型，订单金额
	Integer updateOrderIntimeAndOutimeAndroomCountByNo(Order order);
	//增加order_list订单项
	Integer addOrderListByOrder(OrderList orderList);
	//num-对应的数量
	Integer deleteNumFromRoom(Room room);
}
