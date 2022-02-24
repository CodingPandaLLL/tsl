package com.cpl.tsl.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel(value = "EmployeeVo", description = "EmployeeVo类")
public class EmployeeVo implements Serializable {

    @ApiModelProperty(value = "员工队列")
    List<Employee>  employeeLst;

    public void setEmployeeLst(List<Employee> employeeLst) {
        this.employeeLst = employeeLst;
    }

    public List<Employee> getEmployeeLst() {
        return employeeLst;
    }
}
