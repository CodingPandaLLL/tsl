package com.llltony.springboot.controller;


import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import com.llltony.springboot.bean.ResultMap;
import com.llltony.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired(required = false)
    EmployeeService employeeService;

    //增加学生
    @RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
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

    //删除学生
    @DeleteMapping("/delEmp/{ids}")
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
    @GetMapping("/getEmp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }

    //查询所有的学生
    @GetMapping("/getAllEmp")
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmp();
    }

    //修改学生
    @PutMapping("/updateEmp")
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
