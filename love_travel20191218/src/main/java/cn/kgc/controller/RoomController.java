package cn.kgc.controller;

import cn.kgc.pojo.Order;
import cn.kgc.pojo.Room;
import cn.kgc.service.OrderService;
import cn.kgc.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
@RequestMapping("room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

    //点击事件动态生成住客的个数
    @RequestMapping("addUserInfosByNum")
    public String addUserInfosByNum(String no, Integer num, Integer rId, Order order1, Model model){
        System.out.println(order1);
        Order order = orderService.selectOrderByOrderId(no);
        order.setMoney(order1.getMoney());
        order.setInTime(order1.getInTime());
        order.setOutTime(order1.getOutTime());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<num;i++){
            arrayList.add(i+1);
        }
        model.addAttribute("arrayList",arrayList);
        Room room = roomService.queryRoomByIdAndReserve(rId);
        model.addAttribute("room",room);
        model.addAttribute("num",num);
        model.addAttribute("order",order);
        return "reserve";
    }
}

