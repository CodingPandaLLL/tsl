package com.cpl.tsl.dao;


import com.cpl.tsl.bean.SysDataDict;

import java.util.List;

public interface SysDataDictDao {

    int deleteByPrimaryKey(Integer id);

    int insert(SysDataDict record);

    int insertSelective(SysDataDict record);

    SysDataDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDataDict record);

    int updateByPrimaryKey(SysDataDict record);

    List<SysDataDict> selectBySelective(SysDataDict sysDataDict);
}