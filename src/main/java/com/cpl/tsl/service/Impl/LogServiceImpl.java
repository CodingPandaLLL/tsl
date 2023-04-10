package com.cpl.tsl.service.Impl;

import com.cpl.tsl.bean.Log;
import com.cpl.tsl.bean.Tables;
import com.cpl.tsl.bean.base.Page;
import com.cpl.tsl.dao.LogDao;
import com.cpl.tsl.service.LogService;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lll
 * @since 2023-04-10
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogDao logDao;

    /**
     * 根据当前时间按照分钟级别建表进行动态建表
     */
    @Override
    public void saveLog(Log log) {
        //获取当前时间
        Date nowTome = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String nowMintux = dateFormat.format(nowTome);
        //判断当前时间级别(分钟)是否有表
        String logTable = "Log" + nowMintux;
        Integer table = logDao.queryTableByName(logTable);
        //没有表进行建表
        if (table == 0) {
            logDao.createTable(logTable);
        }
        //进行数据插入
        //id组成（时间yyyyMMddhhmmssSSS+系统码tsl+随机码）
        SimpleDateFormat dateFormatForId = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Random r = new Random();
        String random = String.format("%012d", r.nextInt(999999999));
        log.setId(dateFormatForId.format(nowTome) + "tsl" + random);
        logDao.saveLog(logTable, log);
    }

    @Override
    public void delLog(String ids) {
        String[] idArr = ids.split(",");
        for (int i = 0; i < idArr.length; i++) {
            //通过id取值获取对应的表名
            String tableName = "log" + idArr[i].substring(0, 12);
            //通过表名和id值进行删除
            logDao.deleteByIdAndTableName(idArr[i], tableName);
        }
    }

    @Override
    public Log getLogById(String id) {
        //通过id取值获取对应的表名
        String tableName = "log" + id.substring(0, 12);
        //通过表名和id值进行查詢
        return logDao.queryByIdAndTableName(id, tableName);
    }

    @Override
    public Page<Log> getPage(int pageSize, int pageNo) {
        //查询所有的表名
        List<Tables> logList = logDao.getAllLogTable();
        if (logList != null && logList.size() > 0) {
            //动态分页查询
            int page = (pageNo - 1) * pageSize;
            int logCount = logDao.getLogCount(logList);
            if (logCount > 0) {
                Page<Log> logPage = new Page<>();
                List<Log> logs = logDao.getPage(logList, pageSize, page);
                logPage.setRows(logs);
                logPage.setPageSize(pageSize);
                logPage.setCurrentPage(pageNo);
                logPage.setTotalCount(logCount);
                logPage.setTotalPage(logCount / pageSize + 1);
                return logPage;
            } else {
                return new Page<>();
            }
        }
        return new Page<>();
    }

}
