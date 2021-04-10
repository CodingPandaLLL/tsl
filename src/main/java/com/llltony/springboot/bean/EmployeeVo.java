package com.llltony.springboot.bean;

import java.io.Serializable;
import java.util.List;

public class EmployeeVo implements Serializable {

    List<Employee>  employeeLst;

    public void setEmployeeLst(List<Employee> employeeLst) {
        this.employeeLst = employeeLst;
    }

    public List<Employee> getEmployeeLst() {
        return employeeLst;
    }
}
