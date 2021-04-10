package com.llltony.springboot.dao;

import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeDao")
public interface EmployeeDao {

    public Employee getEmpById(Integer id);

    public void saveEmpLst(@Param("empLst")List pLst);

    public void saveEmp(Employee employee);

    public List<Employee> getAllEmp();

    void delEmp(long id);

    void updateEmp(Employee employee);
}
