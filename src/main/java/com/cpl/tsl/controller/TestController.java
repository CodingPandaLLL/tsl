package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSON;
import com.cpl.tsl.bean.Employee;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private KafkaTemplate kafkaTemplate;


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

    @RequestMapping(value = "/sendKafkaMessage", method = RequestMethod.POST)
    @ApiOperation(value = "kafka发送消息", notes = "kafka发送消息")
    public ResultMap sendKafkaMessage() {
        ResultMap resultMap = new ResultMap();
        try {
            Employee employee = new Employee();
            employee.setdId(1);
            employee.setEmail("2121");
            employee.setLastName("jsdkjdsjk");
            kafkaTemplate.send("user-log", JSON.toJSONString(employee));
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        } catch (Exception exception) {
            logger.info(exception.getMessage());
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        }


        return resultMap;
    }


}
