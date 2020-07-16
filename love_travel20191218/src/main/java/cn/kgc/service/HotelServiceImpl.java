package cn.kgc.service;

import cn.kgc.dao.HotelMapper;
import cn.kgc.dao.RoomMapper;
import cn.kgc.pojo.Hotel;
import cn.kgc.pojo.Room;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/16.
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public PageInfo<Hotel> queryAllHotel(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<Hotel> hotelList = hotelMapper.queryAllHotel();
        PageInfo pageInfo = new PageInfo(hotelList);
        return pageInfo;
    }

    @Override
    public PageInfo<Hotel> queryHotelByCondition(Integer pageNo, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNo,pageSize);
        List<Hotel> hotelList = hotelMapper.queryHotelByCondition(map);
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotelList);
        return pageInfo;
    }

    @Override
    public Hotel queryHotelById(Integer id) {
        return hotelMapper.queryHotelById(id);
    }
}
