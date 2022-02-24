package com.cpl.tsl.controller;


import com.cpl.tsl.bean.Employee;
import com.cpl.tsl.bean.EmployeeVo;
import com.cpl.tsl.bean.ResultMap;
import com.cpl.tsl.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@Api(tags = "员工模块")
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @Resource
    RabbitTemplate rabbitTemplate;

    //增加学生
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value="增加学生",notes = "增加学生信息")
    public ResultMap saveEmp(@RequestBody  @ApiParam(required = true, value = "学生对接")  EmployeeVo employeeVo) {
        ResultMap resultMap = new ResultMap();
        try {
            employeeService.saveEmp(employeeVo);
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("保存失败");
        }
        return resultMap;
    }

    //通过消息队列异步增加学生
    @RequestMapping(value = "/addRebbitMq", method = RequestMethod.POST)
    @ApiOperation(value="通过消息队列异步增加学生",notes = "通过消息队列异步增加学生")
    public ResultMap addRebbitMq(@RequestBody  @ApiParam(required = true, value = "学生对接")  EmployeeVo employeeVo) {
        ResultMap resultMap = new ResultMap();
        try {
            String messageId = String.valueOf(UUID.randomUUID());
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageData", employeeVo);
            map.put("createTime", createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("EmployeeDirectExchange", "EmployeeDirectRouting", map);
//            employeeService.saveEmp(employeeVo);
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("保存失败");
        }
        return resultMap;
    }

    //删除学生
    @DeleteMapping("/{ids}")
    @ApiOperation(value="删除学生",notes = "删除学生")
    public ResultMap delEmp(@PathVariable("ids")  @ApiParam(required = true, value = "逗号分隔id字符串")  String ids) {
        ResultMap resultMap = new ResultMap();
        try {
            employeeService.delEmp(ids);
            resultMap.setStatus("200");
            resultMap.setMessage("删除成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("删除失败");
        }
        return resultMap;
    }

    //查询学生
    @GetMapping("/{id}")
    @ApiOperation(value="查询学生",notes = "查询学生")
    public Employee getEmp(@PathVariable("id")  @ApiParam(required = true, value = "id")  Integer id) throws IOException {
        return employeeService.getEmpById(id);
    }

    //查询所有的学生
    @GetMapping("/getAll")
    @ApiOperation(value="查询所有的学生",notes = "查询所有的学生")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmp();
    }

    //修改学生
    @PutMapping("/")
    @ApiOperation(value="修改学生",notes = "修改学生")
    public ResultMap updateEmp(@RequestBody  @ApiParam(required = true, value = "学生实体")  Employee employee) {
        ResultMap resultMap = new ResultMap();
        try {
            employeeService.updateEmp(employee);
            resultMap.setStatus("200");
            resultMap.setMessage("保存成功");
        } catch (Exception e) {
            resultMap.setStatus("500");
            resultMap.setMessage("保存失败");
        }
        return resultMap;
    }
}
