package cn.kgc.service;


import cn.kgc.pojo.Comment;
import cn.kgc.pojo.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ToCommentServiceImplTest {
    @Test
    public void queryHotelById() throws Exception {
        Integer id = 1;
        Hotel hotel = toCommentService.queryHotelById(id);
        if (null != hotel) {
            System.out.println(hotel);
        }
    }

    @Autowired
    private ToCommentService toCommentService;
    @Test
    public void toComment() {
        Map<String,Object>map=new HashMap<String, Object>();
        Comment comment=new Comment();
        comment.setHotel_id(1);
        comment.setContent("这是添加测试");
        comment.setScore(4);
        comment.setRoomTypeId(4);
        map.put("comment",comment);
        map.put("oId",12);
        int index=toCommentService.ToComment(map);
        System.out.println(index==1?"添加评价完美成功":"添加失败");
    }
}
