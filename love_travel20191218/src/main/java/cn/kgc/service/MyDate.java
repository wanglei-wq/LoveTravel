package cn.kgc.service;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class MyDate{
    public static int getDatePoor(Date beginDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = 0;
        if(beginDate.after(endDate)) {
            diff = beginDate.getTime() - endDate.getTime();
        }else {
            diff = endDate.getTime() - beginDate.getTime();
        }
        // 计算差多少天
        int day = (int) (diff / nd);
        return day;
    }
    public static Date getSomeDay(Date date, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }
}