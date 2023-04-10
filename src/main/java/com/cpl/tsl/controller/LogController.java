package com.cpl.tsl.controller;


import com.cpl.tsl.bean.Log;
import com.cpl.tsl.bean.base.Page;
import com.cpl.tsl.bean.base.ResultMap;
import com.cpl.tsl.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;


@RestController
@RequestMapping("/log")
@Api(tags = "日志模块")
public class LogController {

    @Resource
    LogService logService;

    //增加日志
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "增加日志", notes = "增加日志信息")
    public ResultMap saveEmp(@RequestBody @ApiParam(required = true, value = "日志") Log log) {
        ResultMap resultMap = new ResultMap();
        try {
            logService.saveLog(log);
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("保存失败");
        }
        return resultMap;
    }

    //删除日志
    @DeleteMapping("/{ids}")
    @ApiOperation(value = "删除日志", notes = "删除日志")
    public ResultMap delLog(@PathVariable("ids") @ApiParam(required = true, value = "逗号分隔id字符串") String ids) {
        ResultMap resultMap = new ResultMap();
        try {
            logService.delLog(ids);
            resultMap.setStatus("200");
            resultMap.setMessage("删除成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("删除失败");
        }
        return resultMap;
    }

    //查询日志
    @GetMapping("/{id}")
    @ApiOperation(value = "查询日志", notes = "查询日志")
    public ResultMap getLog(@PathVariable("id") @ApiParam(required = true, value = "id") String id) throws IOException {
        ResultMap resultMap = new ResultMap();
        resultMap.setData(logService.getLogById(id));
        resultMap.setStatus("200");
        resultMap.setMessage("成功");
        return resultMap;
    }

    //查询所有的日志
    @GetMapping("/getPage")
    @ApiOperation(value = "查询所有的日志带分页", notes = "查询所有的日志带分页")
    public Page<Log> getAllEmp(
            @ApiParam(name = "pageSize", value = "每页大小", required = true) @RequestParam Integer pageSize,
            @ApiParam(name = "pageNo", value = "开始页", required = true) @RequestParam Integer pageNo) {
        return logService.getPage(pageSize,pageNo);
    }


}
