package com.cpl.tsl.service;

import com.cpl.tsl.bean.Employee;
import com.cpl.tsl.bean.Log;
import com.cpl.tsl.bean.base.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * 日志模块service
 */
@Transactional
public interface LogService {

    void saveLog(Log log);

    void delLog(String ids);


    Log getLogById(String id);

    Page<Log> getPage(int pageSize, int pageNo);
}
