package cn.kgc.service;

import cn.kgc.pojo.Hotel;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/16.
 */
public interface HotelService {
    //查询所有酒店
    PageInfo<Hotel> queryAllHotel(Integer pageNo, Integer pageSize);

    //根据条件查询酒店
    PageInfo<Hotel> queryHotelByCondition(Integer pageNo, Integer pageSize, Map<String,Object> map);

    //根据酒店id查询酒店详细信息（包含房间信息）
    Hotel queryHotelById(Integer id);
}
