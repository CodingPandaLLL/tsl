package com.cpl.tsl.service;

import com.cpl.tsl.bean.SysDataDict;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Transactional
public interface SysDataDictService {

    public SysDataDict getSysDataDictById(Integer id) throws IOException;

    List<SysDataDict> getAllSysDataDict();

    void delSysDataDict(String ids);

    void updateSysDataDict(SysDataDict SysDataDict);

    /**
     * 根据字典编码和值编码查询对应的字典值
     *
     * @param code  值编码
     * @param fCode 字典编码
     * @return com.cpl.tsl.bean.SysDataDict
     * @author: lll
     * @date: 2022年03月14日 13:03:10
     */
    SysDataDict getSysDataDictByCodeAndFCode(String code, String fCode);
}
