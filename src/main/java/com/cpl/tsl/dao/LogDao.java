package com.cpl.tsl.dao;

import com.cpl.tsl.bean.Log;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cpl.tsl.bean.Tables;
import com.cpl.tsl.bean.base.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lll
 * @since 2023-04-10
 */
public interface LogDao extends BaseMapper<Log> {

    int queryTableByName(@Param("tableName") String tableName);

    int createTable(@Param("tableName") String tableName);

    void saveLog(@Param("tableName") String tableName, @Param("log") Log log);

    void deleteByIdAndTableName(@Param("id") String id, @Param("tableName") String tableName);

    Log queryByIdAndTableName(@Param("id") String id,@Param("tableName")  String tableName);

    List<Tables> getAllLogTable();

    List<Log> getPage(@Param("logList") List logList, @Param("pageSize") int pageSize, @Param("page") int page);

    int getLogCount(@Param("logList") List<Tables> logList);
}
