package cn.kgc.service;

import cn.kgc.dao.CommentMapper;
import cn.kgc.pojo.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/20.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public PageInfo<Comment> queryAllComment(Integer pageNo,Integer pageSize,Integer hotel_id, Integer status) {
        PageHelper.startPage(pageNo, pageSize);
        List<Comment> list = commentMapper.queryAllComment(hotel_id, status);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
