package com.llltony.springboot.bean;

import java.util.List;

public class EmployeeVo{

    List<Employee>  employeeLst;

    public void setEmployeeLst(List<Employee> employeeLst) {
        this.employeeLst = employeeLst;
    }

    public List<Employee> getEmployeeLst() {
        return employeeLst;
    }
}
