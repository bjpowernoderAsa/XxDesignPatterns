package com.designpatterns.learntemplatefactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/5/17 15:59
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = "2021-05-17";
        Date date = ft.parse(endDate);
//        Integer num = Integer.valueOf(endDate.substring(8))+1;
//        String a = endDate.substring(8);
//        endDate.replace("18","17");
//        endDate.replace("-17","18");

//        String number = "123,456,5234,52345,63456,7456,7";
//        String newNumber = number.replace(",", ";");
//        String Number = number.replace("7", "0");
//        System.out.println("-------------------->>"+endDate);
//        System.out.println("-----------------------<<<-------"+newNumber);

        System.out.println("------------<<-------------"+date);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往后增加一天,整数  往后推,负数往前移动
        calendar.add(Calendar.DATE,1);
        //这个时间就是日期往后推一天的结果
        date=calendar.getTime();
        System.out.println("-------------------->>"+date.toString());

        Date date2 = new Date();
        String time2 = ft.format(date);

        System.out.println("=====================>"+13000/21);
    }
}
