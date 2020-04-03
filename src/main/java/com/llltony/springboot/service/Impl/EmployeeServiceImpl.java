package com.llltony.springboot.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import com.llltony.springboot.dao.EmployeeDao;
import com.llltony.springboot.service.EmployeeService;
import com.llltony.springboot.socket.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired(required = false)
    EmployeeDao employeeDao;

    @Override
    public Employee getEmpById(Integer id) {
        Employee ee=employeeDao.getEmpById(id);
        return ee;
    }

    @Override
    public void saveEmp(EmployeeVo employeelll) {

        int n=employeelll.getEmployeeLst().size();
        WebSocket ss=new WebSocket();
        if (n>1){
            List<Employee> employeeLst=employeelll.getEmployeeLst();
            employeeDao.saveEmpLst(employeeLst);
            JSONObject json=new JSONObject();
            json.put("username","");
            json.put("content","新增了"+employeeLst.size()+"名学生");
            ss.OnMessage(json.toJSONString());
        }else{
            employeeDao.saveEmp(employeelll.getEmployeeLst().get(0));
            JSONObject json=new JSONObject();
            json.put("username","");
            json.put("content","新增了1名学生"+employeelll.getEmployeeLst().get(0).getLastName());
            ss.OnMessage(json.toJSONString());
        }
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeDao.getAllEmp();
    }

    @Override
    public void delEmp(String ids) {
        String[] idArr=ids.split(",");
        for (int i=0;i<idArr.length;i++){
            long id = Long.parseLong(idArr[i]);
            employeeDao.delEmp(id);
        }
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }
}
