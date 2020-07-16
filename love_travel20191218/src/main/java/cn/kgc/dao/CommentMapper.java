package cn.kgc.dao;

import cn.kgc.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/12/20.
 */
public interface CommentMapper {
    //查询酒店所有评论
    List<Comment> queryAllComment(@Param("hotel_id") Integer hotel_id,@Param("status")Integer status);
}
