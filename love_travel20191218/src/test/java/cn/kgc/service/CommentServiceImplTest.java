package cn.kgc.service;

import cn.kgc.pojo.Comment;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2019/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml"})
public class CommentServiceImplTest {
    @Autowired
    CommentService commentService;
    @Test
    public void queryAllComment() throws Exception {
        PageInfo<Comment> pageInfo = commentService.queryAllComment(1, 3, 1, 1);
        List<Comment> list = pageInfo.getList();
        if (null != list) {
            for (Comment comment : list) {
                System.out.println(comment);
            }
        }
        System.out.println("当前：" + pageInfo.getPageNum() + "页,共" + pageInfo.getTotal() + "页,页面容量：" + pageInfo.getPageSize());
    }

}