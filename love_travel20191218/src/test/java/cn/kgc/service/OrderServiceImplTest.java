package cn.kgc.service;

import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Order;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderServiceImplTest {
    @Test
    public void queryHotelNameById() throws Exception {
        Hotel hotel = orderService.queryHotelNameById(133);
        if (null != hotel) {
            System.out.println(hotel);
        }
    }

    @Autowired
    private OrderService orderService;
    @Test
    public void queryAllOrder() {
        Order order1 = new Order();

        String text = "2019-07-25 00:00:33";
        String text2 = "2019-12-20 00:54:32";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(text, formatter);
        LocalDateTime parse2 = LocalDateTime.parse(text2, formatter);

        Date date = Date.from( parse.atZone( ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from( parse.atZone( ZoneId.systemDefault()).toInstant());
        //order1.setInTime(date);
        //order1.setOutTime(date2);
        order1.setState("已付款");
        PageInfo<Order> pageInfo = orderService.queryAllOrder(order1,1, 10);
        for (Order order : pageInfo.getList()) {
            System.out.println(order);
        }
    }

    @Test
    public void show2() {
        Order order = orderService.queryOrderById(363);
        System.out.println(order);

    }

    @Test
    public void show3() {
        Integer integer = orderService.deleteOrderById(1);
        System.out.println(integer);
    }
}