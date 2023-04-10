package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
import com.cpl.tsl.bean.base.Page;
import com.cpl.tsl.bean.Person;
import com.cpl.tsl.bean.base.ResultMap;
import com.cpl.tsl.bean.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * demo类
 *
 * @author: lll
 * @date: 2021年06月02日 18:06:58
 */
@RestController
@RequestMapping("/")
@Api(tags = "样例模块")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/testConnectTime")
    @ApiOperation(value = "测试连接时长接口", httpMethod = "GET", notes = "测试连接时长接口", nickname = "测试")
    public ResultMap<JSONObject> testConnectTime(@ApiParam(value = "睡眠时间") @RequestParam(defaultValue = "1") long outTime) {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        try {
            Thread.sleep(outTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
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
