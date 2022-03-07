package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
import com.cpl.tsl.bean.Jgdwzc;
import com.cpl.tsl.bean.Ml;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.utils.JacksonUtil;
import com.cpl.tsl.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    private RedisTemplate<String, String> template;

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

    //post测试
    @RequestMapping(value = "/Catalog/CreateCataLog", method = RequestMethod.POST)
    @ApiOperation(value = "测试请求CreateCataLog", notes = "测试请求CreateCataLog")
    public ResultMap addRebbitMq(@RequestBody @ApiParam(required = true, value = "Ml") Ml jsonObject) {
        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("请求成功");
        logger.info(JacksonUtil.toJsonString(jsonObject));
        return resultMap;
    }

    //post测试
    @RequestMapping(value = "/Supply/CreateOrg", method = RequestMethod.POST)
    @ApiOperation(value = "测试请求CreateOrg", notes = "测试请求CreateOrg")
    public JSONObject CreateOrg(@RequestBody @ApiParam(required = true, value = "Jgdwzc") Jgdwzc jsonObject) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject1 = new JSONObject();
        jSONObject.put("code", 1);
        jSONObject1.put("share_org_id", "b22b8e60-4573-466b-ab7d-9c50d2fcb0ab");
        jSONObject.put("data", jSONObject1);
        jSONObject.put("messgae", "处理成功！");
        return jSONObject;
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


}
