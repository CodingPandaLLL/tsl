package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
import com.cpl.tsl.bean.Page;
import com.cpl.tsl.bean.Person;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.bean.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * demo类
 *
 * @author: lll
 * @date: 2021年06月02日 18:06:58
 */
@RestController
@RequestMapping("/demo")
@Api(tags = "样例模块")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/requestThirdApi")
    @ApiOperation(value = "调用第三方接口Demo", httpMethod = "GET", notes = "调用第三方接口Demo", nickname = "测试")
    public ResultMap<JSONObject> requestThirdApi() {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        List<String> ids = Arrays.asList("06552d3e38c44536af8b01234c3642c0","928e9b67c67446718faee67fd7f84b27","30d49430b468429c809a6425f3dd5f0c","8550bfbc72254bf8aaba6a4cfd171cc7","123a16e63275401f940ac0dfd647807c","f6610fdf871943f4ba183f84fd085adc","dea2d291b54f44788b0e623ffcefcc3a","b58ab2d598924bc0940438eafc34c022");
        for (int i = 0; i < ids.size(); i++)  {
            String url = "http://127.0.0.1:955/providerDexchangeOut/v1.0/push/zyscPush";
            JSONObject json = new JSONObject();
            json.put("id", ids.get(i));
            json.put("resType", "table");
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON_UTF8);
//            headers.add("Accept", org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE);
//            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
            HttpEntity<JSONObject> entity = new HttpEntity<>(json, null);
            String result = restTemplate.postForObject(url, entity, String.class);
            JSONObject JsonObject = JSONObject.parseObject(result);
//            JsonObject = JSON.parseObject(JsonObject.getString("content"));
            logger.info("  "+i+"   "+ids.get(i)+"    "+String.valueOf(JsonObject));
        }

        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }

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
        Person person = new Person();
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
            Person person = new Person();
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
            Person person = new Person();
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
