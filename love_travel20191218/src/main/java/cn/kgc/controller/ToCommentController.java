package cn.kgc.controller;

import cn.kgc.pojo.Comment;
import cn.kgc.pojo.Hotel;
import cn.kgc.service.ToCommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/24.
 */
@Controller
@RequestMapping("toCommentController")
public class ToCommentController {
    @Autowired
    private ToCommentService toCommentService;

    //查询酒店信息根据酒店的id
    @RequestMapping("queryHotelById")
    public String queryHotelById(@Param("hId") Integer hId,
                                 @Param("oId") Integer oId,
                                 @Param("roomTypeId") Integer roomTypeId,
                                 Model model){
        Hotel hotel = toCommentService.queryHotelById(hId);
        if (null != hotel) {
            model.addAttribute("hotel", hotel);
            model.addAttribute("oId", oId);
            model.addAttribute("roomTypeId", roomTypeId);
            return "hotelPingJia";
        } else {
            return null;
        }
    }
    //评论的添加，酒店sum、count修改，订单状态的改变
    @ResponseBody
    @RequestMapping("toComment")
    public String comment(@RequestParam("hotel_id")Integer hotel_id,
                          @RequestParam("score")Integer score,
                          @RequestParam("content")String content,
                          @RequestParam("oId")Integer oId,
                          @RequestParam("roomTypeId")Integer roomTypeId){
        Map<String, Object> map = new HashMap<>();
        map.put("oId", oId);
        Comment comment = new Comment();
        comment.setHotel_id(hotel_id);
        comment.setScore(score);
        comment.setContent(content);
        comment.setRoomTypeId(roomTypeId);
        map.put("comment", comment);
        int i = toCommentService.ToComment(map);
        if (i > 0) {
            return "1";
        }
        return "0";
    }
}
