package com.llltony.springboot.service;

import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Transactional
public interface EmployeeService {

    public Employee getEmpById(Integer id) throws IOException;

    void saveEmp(EmployeeVo employeeLst);

    List<Employee> getAllEmp();

    void delEmp(String ids);

    void updateEmp(Employee employee);
}
