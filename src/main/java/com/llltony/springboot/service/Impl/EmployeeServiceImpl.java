package com.llltony.springboot.service.Impl;

import com.llltony.springboot.bean.Employee;
import com.llltony.springboot.bean.EmployeeVo;
import com.llltony.springboot.dao.EmployeeDao;
import com.llltony.springboot.service.EmployeeService;
import com.llltony.springboot.utils.JacksonUtil;
import com.llltony.springboot.utils.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired(required = false)
    EmployeeDao employeeDao;

    @Resource
    private RedisUtil redisUtil;

    private static final Logger logger = Logger.getLogger(com.llltony.springboot.service.Impl.EmployeeServiceImpl.class);

    @Override
    public Employee getEmpById(Integer id) throws IOException {
        Employee employee = new Employee();
        //尝试通过id从redis中获取用户信息
        Object object = redisUtil.get(id + "");

        //如果从redis中获取的用户信息不为空，直接读取redis获取的用户信息，否则查询数据库
        if (object != null) {
            employee=JacksonUtil.toBean(JacksonUtil.toJsonString(object),Employee.class);
            logger.info("从redis中获取数据： " + JacksonUtil.toJsonString(employee));
        } else {
            //查询数据库
            employee = employeeDao.getEmpById(id);
            //向redis数据库从插入用户信息
            redisUtil.set(id + "", employee);
            logger.info("从数据库中获取数据： " + JacksonUtil.toJsonString(employee));
        }
        return employee;
    }

    @Override
    public void saveEmp(EmployeeVo employeelll) {

        int n = employeelll.getEmployeeLst().size();
        if (n > 1) {
            List<Employee> employeeLst = employeelll.getEmployeeLst();
            employeeDao.saveEmpLst(employeeLst);
        } else {
            employeeDao.saveEmp(employeelll.getEmployeeLst().get(0));
        }
    }

    @Override
    public List<Employee> getAllEmp() {
        return employeeDao.getAllEmp();
    }

    @Override
    public void delEmp(String ids) {
        String[] idArr = ids.split(",");
        for (int i = 0; i < idArr.length; i++) {
            long id = Long.parseLong(idArr[i]);
            employeeDao.delEmp(id);
        }
    }

    @Override
    public void updateEmp(Employee employee) {
        employeeDao.updateEmp(employee);
    }
}
