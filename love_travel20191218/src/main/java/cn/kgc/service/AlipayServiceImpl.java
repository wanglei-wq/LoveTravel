package cn.kgc.service;

import cn.kgc.dao.AlipayMapper;
import cn.kgc.dao.RoomMapper;
import cn.kgc.pojo.AlipayOrder;
import cn.kgc.pojo.Order;
import cn.kgc.pojo.OrderList;
import cn.kgc.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlipayServiceImpl implements AlipayService{
	@Autowired
	private AlipayMapper alipayMapper;
	@Autowired
    private RoomMapper roomMapper;
	@Override
	public Integer addAlipayOrder(AlipayOrder alipayOrder){
		return alipayMapper.addAlipayOrder(alipayOrder);
	}
	/**
	 * 修改订单地址。电话和收货人
	 */
	@Override
	public Integer updateOrderIntimeAndOutimeAndroomCountByNo(Order order){
		Integer integer = alipayMapper.updateOrderIntimeAndOutimeAndroomCountByNo(order);
		return integer;
	}

	@Override
	public Integer addOrderListByOrder(Integer oId, Integer[] cId,Integer rId) {
		OrderList orderList = null;
        Integer integer=0;
		for(int i =0;i<cId.length;i++){
            integer=0;
			orderList = new OrderList();
			orderList.setRoomId(rId);
			orderList.setOrderId(oId);
			orderList.setContactId(cId[i]);
            integer = alipayMapper.addOrderListByOrder(orderList);
        }
		return integer;
	}
    //减少剩余房间数量
    @Override
    public Integer deleteNumFromRoom(Room room) {
        Room queryRoom = roomMapper.queryRoomByIdAndReserve(room.getRId());
        //剩余房间数量
        int num = queryRoom.getNum() - room.getNum();
        if(num>=0){
            queryRoom.setNum(num);
        }
        return alipayMapper.deleteNumFromRoom(queryRoom);
    }

    /**
	 * 修改订单的状态
	 */
	@Override
	public Integer updateOrderStateByOrderId(String out_trade_no){
		return	alipayMapper.updateOrderStateByOrderId(out_trade_no);
	}
}
