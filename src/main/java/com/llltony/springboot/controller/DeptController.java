package com.llltony.springboot.controller;


import com.llltony.springboot.bean.Department;
import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.dao.DepartmentMapper;
import com.llltony.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired(required = false)
    DepartmentMapper departmentMapper;

    @Autowired(required = false)
    EmployeeService employeeService;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        Department v = departmentMapper.getDeptById(id);
        return v;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }


}
