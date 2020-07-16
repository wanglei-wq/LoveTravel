package cn.kgc.service;

import cn.kgc.pojo.Room;
import cn.kgc.pojo.User;

/**
 * Created by Administrator on 2019/12/13.
 */
public interface RoomService {
    //根据Id查看详情订房间
    Room queryRoomByIdAndReserve(Integer id);
}
