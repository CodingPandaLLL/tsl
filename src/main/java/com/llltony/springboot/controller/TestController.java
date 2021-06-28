package com.llltony.springboot.controller;


import com.alibaba.fastjson.JSONObject;
import com.llltony.springboot.bean.EmployeeVo;
import com.llltony.springboot.bean.Jgdwzc;
import com.llltony.springboot.bean.Ml;
import com.llltony.springboot.bean.ResultMap;
import com.llltony.springboot.utils.JacksonUtil;
import org.apache.poi.ss.formula.functions.T;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 测试类
 *
 * @author: lll
 * @date: 2021年06月02日 18:06:58
 */
@RestController
@RequestMapping("/")
public class TestController {


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
    public ResultMap addRebbitMq(@RequestBody Ml jsonObject) {
        ResultMap resultMap = new ResultMap();
        resultMap.setStatus("200");
        resultMap.setMessage("请求成功");
        System.out.println(JacksonUtil.toJsonString(jsonObject));
        return resultMap;
    }

    //post测试
    @RequestMapping(value = "/Supply/CreateOrg", method = RequestMethod.POST)
    public JSONObject CreateOrg(@RequestBody Jgdwzc jsonObject) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject1 = new JSONObject();
        jSONObject.put("code", 1);
        jSONObject1.put("share_org_id", "b22b8e60-4573-466b-ab7d-9c50d2fcb0ab");
        jSONObject.put("data", jSONObject1);
        jSONObject.put("messgae", "处理成功！");
        return  jSONObject;
    }


}
