package cn.kgc.controller;

import cn.kgc.pojo.Comment;
import cn.kgc.service.CommentService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/12/20.
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "queryComment",produces = "application/json;charset=utf-8")
    public String queryComment(@Param("pageNo") Integer pageNo,
                               @Param("hotel_id") Integer hotel_id,
                               @Param("status") Integer status,
                               Model model) {
        pageNo = 1;
        Integer pageSize = 20;
        PageInfo<Comment> pageInfo = commentService.queryAllComment(pageNo, pageSize, hotel_id, status);
        model.addAttribute("page", pageInfo);
        System.out.println("--------------->"+model);
        return JSON.toJSONString(model);
    }
}
