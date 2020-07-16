package cn.kgc.controller;

import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Order;
import cn.kgc.pojo.Room;
import cn.kgc.pojo.User;
import cn.kgc.service.OrderService;
import cn.kgc.service.RoomService;
import cn.kgc.util.RandomNumber;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomService roomService;

    //分页查询所有订单
    @RequestMapping(value = "queryAllOrder")
    public String queryAllOrder(Order order, Integer pageNum, Integer pageSize, Model model,HttpSession session) {
        User user = (User) session.getAttribute("userLog");
        order.setUserId(user.getUId());
        if (pageNum == null) {
            pageNum = 0;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        PageInfo<Order> pageInfo = orderService.queryAllOrder(order, pageNum, pageSize);
        List<Order> orderList = pageInfo.getList();
        if (null == orderList) {
            model.addAttribute("msg", "查询失败！");
            return "404";
        } else {
            model.addAttribute("inTime", order.getInTime());
            model.addAttribute("outTime", order.getOutTime());
            model.addAttribute("state", order.getState());
            model.addAttribute("pageInfo", pageInfo);
            return "order";
        }
    }

    //订单详情
    @RequestMapping("queryOrderById")
    public String queryOrderById(Integer id, Model model) {
        Order orderDetail = orderService.queryOrderById(id);
        Hotel hotel = orderService.queryHotelNameById(orderDetail.getHotelId());
        if (null != orderDetail) {
            model.addAttribute("orderDetail", orderDetail);
            System.out.println(orderDetail);
            model.addAttribute("hotel", hotel);
            return "orderDetail";
        } else {
            return "404";
        }
    }

    //删除订单
    @ResponseBody
    @RequestMapping("deleteOrderById")
    public String deleteOrderById(Integer id) {
        System.out.println(id);
        Integer integer = orderService.deleteOrderById(id);
        if (integer > 0) {
            return "success";
        } else {
            return "404";
        }
    }

    /**
     * 选择房间，生成订单，跳到支付界面进行支付
     */
    //根据Id查看详情订房间
    @RequestMapping("addOrderAndQueryRoomByIdAndReserve")
    public String addOrderAndQueryRoomByIdAndReserve(@Param("id") Integer id, @Param("uId") Integer uId, @Param("hId") Integer hId,@Param("money") Double money, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession httpSession) {
        Order order = orderService.optionProductsAddOrderAndCheckOut(new Order(RandomNumber.orderRandom(),money, new Date(), uId, hId));
        if (order != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                arrayList.add(i + 1);
            }
            model.addAttribute("arrayList", arrayList);
            Room room = roomService.queryRoomByIdAndReserve(id);
            model.addAttribute("room", room);
            model.addAttribute("order", order);
            return "reserve";
        } else {
            return "404";
        }
    }
}
