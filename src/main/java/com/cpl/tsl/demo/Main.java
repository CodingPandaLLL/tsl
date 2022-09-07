package com.cpl.tsl.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        // 创建当前时间的日历对象
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        // 获取日历对象中的数据
        // public int get(int field) 获取某个字段的值。
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);// 2020
        System.out.println(cal.get(Calendar.MONTH));// 5
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));// 24
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));// 2

        System.out.println("=====================");

        // public void set(int field,int value) 设置某个字段的值
        // 需求:修改cal对象中的年份字段的值为 1999
        cal.set(Calendar.YEAR,1999);
        System.out.println(cal.get(Calendar.YEAR));// 1999

        // public void add(int field,int amount)为某个字段增加/减少指定的值
        // 需求: 为年份字段的值增加2年
        cal.add(Calendar.YEAR,2);
        System.out.println(cal.get(Calendar.YEAR));// 2001

        // 需求: 为年份字段的值增加-2年
        cal.add(Calendar.YEAR,-2);
        System.out.println(cal.get(Calendar.YEAR));// 1999

        System.out.println("=====================");
        // void setTime(Date date)  使用给定的 Date 设置此 Calendar 的时间。
        // 获取当前日历对象
        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal2);// 当前日期对应的日历对象

        // 需求: 获取距离标准基准时间1小时的日期对应的日历对象
        // 创建一个距离标准基准时间1小时的日期对象
        Date date = new Date(1*60*60*1000);
        // 调用日历对象的setTime方法,设置日历对象表示的日期
        cal2.setTime(date);
        System.out.println(cal2);// 距离标准基准时间1小时的日期对应的日历对象

        System.out.println("=====================");
        // boolean before(Object when) 判断此 Calendar 表示的时间是否在指定 Object 表示的时间之前，返回判断结果。
        Calendar cal3 = Calendar.getInstance();
        // cal2: 1970-01-01 09:00:00 时间的日历对象
        // cal3: 当前时间的日历对象
        System.out.println(cal2.before(cal3));// true
        System.out.println(cal3.after(cal2));// true
    }

    // Calendar类的构造方法
    private static void method01() {
        // 1.通过构造方法创建日历对象
        GregorianCalendar gc1 = new GregorianCalendar();
        // 2.通过Calendar类的静态方法创建日历对象
        Calendar cal = Calendar.getInstance();

        System.out.println(gc1);
        System.out.println(cal);
    }
}