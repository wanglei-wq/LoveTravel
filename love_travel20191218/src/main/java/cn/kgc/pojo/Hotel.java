package cn.kgc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private Integer hId;
    private String name;
    private String cityName;
    private Integer star;
    private String position;
    private String count;
    private String sum;
    private String imgSrc;
    private List<Room> rooms;
}
