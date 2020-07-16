package cn.kgc.service;

import cn.kgc.pojo.AlipayOrder;
import cn.kgc.pojo.Order;
import cn.kgc.pojo.Room;

public interface AlipayService {
	/**
	 * 添加交易订单信息
	 */
	Integer addAlipayOrder(AlipayOrder alipayOrder);
	/**
	 * 修改购物车的商品状态
	 */
	Integer updateOrderStateByOrderId(String out_trade_no);

	//修改订单的入住时间和离宿时间，房型，房间数量，订单金额
	Integer updateOrderIntimeAndOutimeAndroomCountByNo(Order order);
	//增加orderList（订单项的数据增加）
	Integer addOrderListByOrder(Integer oId, Integer[] cId, Integer rId);
	//减少剩余房间数量
	Integer deleteNumFromRoom(Room room);
}
