package cn.kgc.service;

import cn.kgc.pojo.Hotel;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HotelServiceImplTest {


    @Autowired
    private HotelService hotelService;
    @Test
    public void queryAllHotel() throws Exception {
        PageInfo pageInfo = hotelService.queryAllHotel(1, 10);
        System.out.println(pageInfo);
    }

    @Test
    public void queryHotelByCondition() throws Exception {
        Map<String, Object> map = new HashMap();
        map.put("cityName","北京");
        map.put("roomNum", 2);
        PageInfo<Hotel> pageInfo = hotelService.queryHotelByCondition(1, 10, map);
        System.out.println(pageInfo);
    }
}