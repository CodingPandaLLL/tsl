package com.cpl.tsl.service.Impl;

import com.cpl.tsl.bean.SysDataDict;
import com.cpl.tsl.dao.SysDataDictDao;
import com.cpl.tsl.service.SysDataDictService;
import com.cpl.tsl.utils.JacksonUtil;
import com.cpl.tsl.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class SysDataDictServiceImpl implements SysDataDictService {

    @Resource
    SysDataDictDao sysDataDictDao;

    @Resource
    private RedisUtil redisUtil;

    private static final Logger logger = LoggerFactory.getLogger(SysDataDictServiceImpl.class);

    @Override
    public SysDataDict getSysDataDictById(Integer id) throws IOException {
        SysDataDict SysDataDict = new SysDataDict();
        //尝试通过id从redis中获取用户信息
        Object object = redisUtil.get(id + "");

        //如果从redis中获取的用户信息不为空，直接读取redis获取的用户信息，否则查询数据库
        if (object != null) {
            SysDataDict = JacksonUtil.toBean(JacksonUtil.toJsonString(object), SysDataDict.class);
            logger.info("从redis中获取数据： " + JacksonUtil.toJsonString(SysDataDict));
        } else {
            //查询数据库
            SysDataDict = sysDataDictDao.selectByPrimaryKey(id);
            //向redis数据库从插入用户信息
            redisUtil.set(id + "", SysDataDict);
            logger.info("从数据库中获取数据： " + JacksonUtil.toJsonString(SysDataDict));
        }
        return SysDataDict;
    }

    @Override
    public List<SysDataDict> getAllSysDataDict() {
        return null;
    }

    @Override
    public void delSysDataDict(String ids) {
        String[] idArr = ids.split(",");
        for (int i = 0; i < idArr.length; i++) {
            long id = Long.parseLong(idArr[i]);
            sysDataDictDao.deleteByPrimaryKey((int) id);
        }
    }

    @Override
    public void updateSysDataDict(SysDataDict SysDataDict) {
        sysDataDictDao.updateByPrimaryKeySelective(SysDataDict);
    }

    /**
     * 根据字典编码和值编码查询对应的字典值
     *
     * @param code  值编码
     * @param fCode 字典编码
     * @return com.cpl.tsl.bean.SysDataDict
     * @author: lll
     * @date: 2022年03月14日 13:03:10
     */
    @Override
    public SysDataDict getSysDataDictByCodeAndFCode(String code, String fCode) {
        //1.根据fcode查询分组字段
        SysDataDict sysDataDict = new SysDataDict();
        sysDataDict.setCode(fCode);
        sysDataDict.setType("0");
        sysDataDict = sysDataDictDao.selectBySelective(sysDataDict).get(0);
        //2.根据fid和code查询对应的值
        SysDataDict sdd = new SysDataDict();
        sdd.setfId(sysDataDict.getId());
        sdd.setCode(code);
        sdd = sysDataDictDao.selectBySelective(sdd).get(0);
        return sdd;
    }
}
