package cn.kgc.service;

import cn.kgc.dao.RoomMapper;
import cn.kgc.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public Room queryRoomByIdAndReserve(Integer id) {
        Room room = roomMapper.queryRoomByIdAndReserve(id);
        return room;
    }
}
