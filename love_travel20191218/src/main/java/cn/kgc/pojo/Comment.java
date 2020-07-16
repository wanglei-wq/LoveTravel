package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/12/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    //
    private Integer id;
    private Integer hotel_id;
    private Integer score;
    private String content;
    private Integer roomTypeId;
    private RoomType roomType;
}
