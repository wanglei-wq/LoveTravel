package cn.kgc.dao;

import cn.kgc.pojo.Comment;
import cn.kgc.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToCommentMapper {
    //新增评论到评论表中
    public int addComment(Comment comment);
    //查询评论次数，以及评价总分
    public List<Hotel> queryMSG(Integer hId);
    //更新评价次数及评价总分

    public int updateCommentByHotel(@Param("count")String count,
                                    @Param("sum")String sum,
                                    @Param("hId") Integer hId);
    //更新订单状态为已评价
    public int updateOrderState(@Param("state")String state,
                                @Param("oId")Integer oId);
    //根据酒店id查询酒店详情
    Hotel queryHotelById(Integer id);
}
