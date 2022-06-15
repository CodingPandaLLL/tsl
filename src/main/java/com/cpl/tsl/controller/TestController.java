package com.cpl.tsl.controller;


import com.cpl.tsl.bean.Page;
import com.cpl.tsl.bean.Person;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.bean.Student;
import com.cpl.tsl.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 测试类
 *
 * @author: lll
 * @date: 2021年06月02日 18:06:58
 */
@RestController
@RequestMapping("/")
@Api(tags = "测试模块")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private RedisUtil redisUtil;

    @Value("${applicationName:tsl}")
    private String applicationName;


    //get测试
    @GetMapping("/getAll")
    public ResultMap getAllEmp() {
        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("保存成功");
        return resultMap;
    }

    /**
     * redis设置定时key，模拟订单下单，超时提醒或者去掉订单
     *
     * @param
     * @return java.lang.String
     * @author: lll
     * @date: 2022年03月07日 13:03:59
     */
    @RequestMapping(value = "/putkeys", method = RequestMethod.POST)
    @ApiOperation(value = "测试redis存储参数", notes = "测试redis存储参数")
    public String putRedisTaskKeys() {

        /**
         * 存入订单信息
         */
        Date date = new Date();
        //设置超时时间30秒
        Long overTime = new Long(30);
        //创建订单号
        String orderNo = UUID.randomUUID().toString();
        //订单信息
        String orderInfo = "这是订单号为：" + orderNo + " 的订单，价格是：2000元,下单时间是：" + date;
        //redis key
        String redisKey = applicationName + ":ORDERINFO|" + orderNo;
        redisUtil.set(redisKey, orderInfo, overTime);
        logger.info("下单时间：" + date);
        logger.info("订单的redisKey " + redisKey + " 订单信息 " + orderInfo);
        return "下单成功";
    }

    /**
     * 手动处理订单，从redis移除订单
     *
     * @param orderNo 订单号
     * @return java.lang.String
     * @author: lll
     * @date: 2022年03月07日 14:03:58
     */
    @RequestMapping(value = "/removeKeys", method = RequestMethod.POST)
    @ApiOperation(value = "测试redis移除参数", notes = "测试redis移除参数")
    public String removeRedisTaskKeys(@ApiParam(name = "orderNo", value = "订单号", required = true) @RequestParam("orderNo") String orderNo) {
        /**
         * 处理订单
         */
        //拼接redis key
        String redisKey = applicationName + ":ORDERINFO|" + orderNo;
        //删除redis key
        redisUtil.del(redisKey);
        logger.info("订单redisKey " + redisKey + " 已处理");
        return "处理完成";
    }

    @GetMapping("/getStudentOne")
    @ApiOperation(value = "getStudentOne", notes = "getStudentOne")
    public ResultMap getStudentOne() {
        //封装参数
        Student student = new Student();
        Person person=new Person();
        person.setId(1);
        person.setName("zhangsao");
        person.setIdCard("123456");
        person.setHair("1");
        student.setPerson(person);
        student.setSchool("yangguang");
        student.setGrade("2");
        student.setClasses("2");
        student.setStudentNo("654321");
        student.setScore("100");


        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("保存成功");
        resultMap.setData(student);
        return resultMap;
    }

    @GetMapping("/getStudentList")
    @ApiOperation(value = "getStudentList", notes = "getStudentList")
    public ResultMap getStudentList() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //封装参数
            Student student = new Student();
            Person person=new Person();
            person.setId(1);
            person.setName("zhangsao");
            person.setIdCard("123456");
            person.setHair("1");
            student.setPerson(person);
            student.setSchool("yangguang");
            student.setGrade("2");
            student.setClasses("2");
            student.setStudentNo("654321");
            student.setScore("100");
            studentList.add(student);
        }

        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("保存成功");
        resultMap.setData(studentList);
        return resultMap;
    }

    @GetMapping("/getStudentPage")
    @ApiOperation(value = "getStudentPage", notes = "getStudentPage")
    public ResultMap getStudentPage() {

        Page<Student> studentPage = new Page<Student>();
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //封装参数
            Student student = new Student();
            Person person=new Person();
            person.setId(1);
            person.setName("zhangsao");
            person.setIdCard("123456");
            person.setHair("1");
            student.setPerson(person);
            student.setSchool("yangguang");
            student.setGrade("2");
            student.setClasses("2");
            student.setStudentNo("65432ying1");
            student.setScore("100");
            studentList.add(student);
        }
        studentPage.setCurrentPage(1);
        studentPage.setPageSize(1);
        studentPage.setRows(studentList);
        studentPage.setTotalCount(1);
        studentPage.setTotalPage(1);

        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("保存成功");
        resultMap.setData(studentPage);
        return resultMap;
    }


}
