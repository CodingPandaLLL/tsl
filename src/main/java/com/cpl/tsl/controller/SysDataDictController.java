package com.cpl.tsl.controller;


import com.cpl.tsl.bean.SysDataDict;
import com.cpl.tsl.service.SysDataDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysDataDict")
@Api(tags = "数据字典模块")
public class SysDataDictController {

    @Resource
    SysDataDictService sysDataDictService;

    //查询学生
    @GetMapping("/{code}/{fCode}")
    @ApiOperation(value = "根据分组编码和字典编码查询字段值", notes = "根据分组编码和字典编码查询字段值")
    public SysDataDict getEmp(@PathVariable("fCode") @ApiParam(required = true, value = "fCode") String fCode, @PathVariable("code") @ApiParam(required = true, value = "code") String code) {
        return sysDataDictService.getSysDataDictByCodeAndFCode(code, fCode);
    }

}
