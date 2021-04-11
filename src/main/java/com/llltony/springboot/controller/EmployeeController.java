package com.llltony.springboot.controller;


import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import com.llltony.springboot.bean.ResultMap;
import com.llltony.springboot.service.EmployeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @Resource
    RabbitTemplate rabbitTemplate;

    //增加学生
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultMap saveEmp(@RequestBody EmployeeVo employeeVo) {
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
    public ResultMap addRebbitMq(@RequestBody EmployeeVo employeeVo) {
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
    public ResultMap delEmp(@PathVariable("ids") String ids) {
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
    public Employee getEmp(@PathVariable("id") Integer id) throws IOException {
        return employeeService.getEmpById(id);
    }

    //查询所有的学生
    @GetMapping("/getAll")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmp();
    }

    //修改学生
    @PutMapping("/")
    public ResultMap updateEmp(@RequestBody Employee employee) {
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
