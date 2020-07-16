package cn.kgc.dao;

import cn.kgc.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/16.
 */
public interface HotelMapper {
    //查询所有酒店
    List<Hotel> queryAllHotel();

    //根据条件查询酒店
    List<Hotel> queryHotelByCondition(Map<String, Object> map);

    //查询酒店详情，通过id
    Hotel queryHotelById(@Param("id") Integer id);
}
