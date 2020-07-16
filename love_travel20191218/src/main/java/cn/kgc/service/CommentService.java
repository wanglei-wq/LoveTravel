package cn.kgc.service;

import cn.kgc.pojo.Comment;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2019/12/20.
 */
public interface CommentService {
    PageInfo<Comment> queryAllComment(Integer pageNo,Integer pageSize,Integer hotel_id, Integer status);
}
