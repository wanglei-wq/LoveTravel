package cn.kgc.dao;

import cn.kgc.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jjking
 *         Created by Administrator on 2019/12/17.
 */
public interface RoomMapper {
    List<Room> queryRoomNumByCondition(@Param("num") Integer num);

    //根据Id查看详情订房间
    Room queryRoomByIdAndReserve(Integer id);
}
