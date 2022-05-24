package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
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


}
