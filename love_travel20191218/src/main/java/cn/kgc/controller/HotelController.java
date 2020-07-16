package cn.kgc.controller;

import cn.kgc.pojo.Hotel;
import cn.kgc.service.HotelService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/16.
 */
@Controller
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * 查询所有的酒店，无条件查询
     * @param model
     * @param pageNo 页码
     * @return Model
     */
    @RequestMapping(value = "queryAllHotel",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryAllHotel(Model model,Integer pageNo) {
        System.out.println(pageNo);
        PageInfo pageInfo = hotelService.queryAllHotel(pageNo,10);
        model.addAttribute("hotelList", pageInfo);
        return JSON.toJSONString(model);
    }

    /**
     * 条件查询酒店
     * @param cityName 城市名称
     * @param indate 入住时间
     * @param outdate 退房时间
     * @param roomNum 房间数量
     * @param personNum 入住人数
     * @param hotelName 酒店名
     * @param level 星级
     * @param orderBy 排序方式
     * @param pageNo 页码
     *
     * @return JSON格式的酒店数据
     */
    @ResponseBody
    @RequestMapping(value = "queryHotelByContidion",produces = "application/json;charset=utf-8")
    public String queryHotelByCondition(String cityName,
                                        String indate,
                                        String outdate,
                                        String roomNum,
                                        String personNum,
                                        String hotelName,
                                        String level,
                                        String orderBy,
                                        Integer pageNo){
        System.out.println("queryHotelByContidion  --start");
        System.out.println("目的地>>>"+cityName);
        System.out.println("入住时间>>>"+indate);
        System.out.println("退房时间>>>"+outdate);
        System.out.println("房间数>>>"+roomNum);
        System.out.println("人数>>>"+personNum);
        System.out.println("酒店名>>>"+hotelName);
        System.out.println("酒店星级>>>"+level);
        System.out.println("排序方式>>>"+orderBy);
        System.out.println("页码号>>>"+pageNo);
        Map<String,Object> map = new HashMap();
        if (pageNo==null){
            pageNo=1;
        }
        //默认价格升序
        if (orderBy==null||orderBy.equals("")){
            orderBy = "1";
        }
        map.put("cityName",cityName);
        map.put("indate", indate);
        map.put("outdate", outdate);
        map.put("roomNum", roomNum);
        map.put("personNum", personNum);
        map.put("hotelName", hotelName);
        map.put("level", level);
        map.put("orderBy", orderBy);
        System.out.println("参数数据>>>>>>"+map);
        System.out.println("页码号>>>>>>"+pageNo);
        PageInfo<Hotel> pageInfo = hotelService.queryHotelByCondition(pageNo, 10, map);
        System.out.println("查询结果>>>>>>"+pageInfo);
        return JSON.toJSONString(pageInfo);
    }

    /**
     * 根据酒店id查询酒店详情
     * @param model Model
     * @param id id
     * @return 查询对象
     */
    @RequestMapping(value = "queryHotelById",produces = "application/json;charset=utf-8")
    @ResponseBody
    private String queryHotelById(Model model, Integer id) {
        Hotel hotel = hotelService.queryHotelById(id);
        System.out.println(hotel);
        model.addAttribute("hotel", hotel);
        return JSON.toJSONString(model);
    }

}
