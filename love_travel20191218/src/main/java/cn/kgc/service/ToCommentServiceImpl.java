package cn.kgc.service;

import cn.kgc.dao.ToCommentMapper;
import cn.kgc.pojo.Comment;
import cn.kgc.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ToCommentServiceImpl implements ToCommentService {
    @Autowired
    private ToCommentMapper toCommentMapper;
    public int ToComment(Map<String,Object> map) {
        Comment comment= (Comment) map.get("comment");
       Integer oId= (Integer) map.get("oId");
       int index1 = toCommentMapper.addComment(comment);
       List<Hotel> list =toCommentMapper.queryMSG(comment.getHotel_id());
       Hotel hotel=list.get(0);
       String oldSum=hotel.getSum();
       String oldCount=hotel.getCount();
       //
       Integer newSum=Integer.parseInt(oldSum)+comment.getScore();
       Integer newCount=Integer.parseInt(oldCount)+1;
       String sum=newSum.toString();
       String count=newCount.toString();
       int index2=toCommentMapper.updateCommentByHotel(count,sum,comment.getHotel_id());
       int index3=toCommentMapper.updateOrderState("已评价",oId);
       if(index1!=0&&index2!=0&&index3!=0){
           return 1;
       }
       return 0;
    }

    @Override
    public Hotel queryHotelById(Integer id) {
        return toCommentMapper.queryHotelById(id);
    }
}
