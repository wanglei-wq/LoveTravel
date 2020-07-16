package cn.kgc.service;

import cn.kgc.pojo.Hotel;

import java.util.Map;

public interface ToCommentService {
    //添加评价
    public int ToComment(Map<String,Object> map);
    //
    public Hotel queryHotelById(Integer id);
}
