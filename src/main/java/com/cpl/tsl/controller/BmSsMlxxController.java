package com.cpl.tsl.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cpl.tsl.bean.*;
import com.cpl.tsl.bean.base.ResultMap;
import com.cpl.tsl.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 目录信息 前端控制器
 * </p>
 *
 * @author lll
 * @since 2023-08-07
 */
@RestController
@RequestMapping("/tsl/bm-ss-mlxx")
@Api(tags = "BmSsMlxxController")
public class BmSsMlxxController {

    @Resource
    private BmSsMlxxService bmSsMlxxService;

    @Resource
    private BmSsYwlmService bmSsYwlmService;

    @Resource
    private BmWdMlxxxService bmWdMlxxxService;

    @Resource
    private MhSsBmService mhSsBmService;

    @Resource
    private Mlxx20230807Service mlxx20230807Service;

    @Resource
    private WdMlxxx20230807Service wdMlxxx20230807Service;

    @GetMapping("/zhuzhishipeizhongyanzhidaodaima")
    @ApiOperation(value = "zhuzhishipeizhongyanzhidaodaima", httpMethod = "GET", notes = "zhuzhishipeizhongyanzhidaodaima", nickname = "zhuzhishipeizhongyanzhidaodaima")
    public ResultMap<JSONObject> zhuzhishipeizhongyanzhidaodaima(@ApiParam(value = "睡眠时间") @RequestParam(defaultValue = "1") long outTime) {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        //start
        /**
         * 替换 组织适配替换中央代码
         */
        List<MhSsBm> mhSsBmList = mhSsBmService.list();
        List<BmSsYwlm> bmSsYwlmList = bmSsYwlmService.list();
        for (MhSsBm mhSsBm : mhSsBmList) {
            for (BmSsYwlm bmSsYwlm : bmSsYwlmList) {
                if (StringUtils.isNotBlank(mhSsBm.getZyywzdbmdm()) && mhSsBm.getZyywzdbmdm().equals(bmSsYwlm.getLmmc())) {
                    mhSsBm.setZyywzdbmdm(bmSsYwlm.getJddm());
                    mhSsBmService.updateById(mhSsBm);
                }
            }
        }
        //end
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }

    /**
     * 业务分类创建子级
     */
    @GetMapping("/yewufenleichuangjianziji")
    @ApiOperation(value = "yewufenleichuangjianziji", httpMethod = "GET", notes = "yewufenleichuangjianziji", nickname = "yewufenleichuangjianziji")
    public ResultMap<JSONObject> yewufenleichuangjianziji() {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        //start

        List<BmSsYwlm> bmSsYwlmList = bmSsYwlmService.list();
        int lmbh = 2000;
        for (BmSsYwlm bmSsYwlm : bmSsYwlmList) {
            long childCount = bmSsYwlmList.stream().filter(s -> bmSsYwlm.getId().equals(s.getLmFid())).count();
            if (childCount == 0 && bmSsYwlm.getCj() == 1) {
                String oldId = bmSsYwlm.getId();
                bmSsYwlm.setLmFid(oldId);
                bmSsYwlm.setId(UUID.randomUUID().toString().replace("-", ""));
                bmSsYwlm.setLmmc("一级");
                bmSsYwlm.setLmjc("一级");
                bmSsYwlm.setJddm("01");
                bmSsYwlm.setLmbh(lmbh + "");
                lmbh++;
                bmSsYwlm.setPxh(lmbh);
                bmSsYwlm.setLmbhgx(bmSsYwlm.getLmbhgx() + "|" + lmbh);
                bmSsYwlmService.save(bmSsYwlm);


                bmSsYwlm.setLmFid(bmSsYwlm.getId());
                bmSsYwlm.setId(UUID.randomUUID().toString().replace("-", ""));
                bmSsYwlm.setLmmc("二级");
                bmSsYwlm.setLmjc("二级");
                lmbh++;
                bmSsYwlm.setPxh(lmbh);
                bmSsYwlm.setLmbhgx(bmSsYwlm.getLmbhgx() + "|" + lmbh);
                bmSsYwlmService.save(bmSsYwlm);

                bmSsYwlm.setLmFid(bmSsYwlm.getId());
                bmSsYwlm.setId(UUID.randomUUID().toString().replace("-", ""));
                bmSsYwlm.setLmmc("三级");
                bmSsYwlm.setLmjc("三级");
                lmbh++;
                bmSsYwlm.setPxh(lmbh);
                bmSsYwlm.setLmbhgx(bmSsYwlm.getLmbhgx() + "|" + lmbh);
                bmSsYwlmService.save(bmSsYwlm);

                bmSsYwlm.setLmFid(bmSsYwlm.getId());
                bmSsYwlm.setId(UUID.randomUUID().toString().replace("-", ""));
                bmSsYwlm.setLmmc("四级");
                bmSsYwlm.setLmjc("四级");
                lmbh++;
                bmSsYwlm.setPxh(lmbh);
                bmSsYwlm.setLmbhgx(bmSsYwlm.getLmbhgx() + "|" + lmbh);
                bmSsYwlmService.save(bmSsYwlm);
            }
        }
        //end
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }


    /**
     * mlxx 构建目录信息
     *
     * @return
     */
    @GetMapping("/mlxx")
    @ApiOperation(value = "mlxx", httpMethod = "GET", notes = "mlxx", nickname = "mlxx")
    public ResultMap<JSONObject> mlxx() {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间

        //start
        List<Mlxx20230807> mlxx20230807List = mlxx20230807Service.list();
        List<MhSsBm> mhSsBmList = mhSsBmService.list();
        List<BmSsYwlm> bmSsYwlmList = bmSsYwlmService.list();
        Map<String, MhSsBm> bmMap = new HashMap<>();
        Map<String, String> bmSsYwlmMap = new HashMap<>();

       /* 20 农业农村部  02023061611364347000000101001586	农户
        16 生态环境部  02023061611364342000000101001106	应急措施
        07 工业和信息化部  02023061611364330500000101001121	工程建设*/
        for (MhSsBm mhSsBm : mhSsBmList) {
            bmMap.put(mhSsBm.getSjgwybmdm(), mhSsBm);
            if (StringUtils.isNotBlank(mhSsBm.getZyywzdbmdm())) {
                if ("20".equals(mhSsBm.getZyywzdbmdm())) {
                    bmSsYwlmMap.put(mhSsBm.getBmmc(), "02023061611364347000000101001586");
                    continue;
                }
                if ("16".equals(mhSsBm.getZyywzdbmdm())) {
                    bmSsYwlmMap.put(mhSsBm.getBmmc(), "02023061611364342000000101001106");
                    continue;
                }
                if ("07".equals(mhSsBm.getZyywzdbmdm())) {
                    bmSsYwlmMap.put(mhSsBm.getBmmc(), "02023061611364330500000101001121");
                    continue;
                }
                BmSsYwlm bmSsYwlm = bmSsYwlmList.stream().filter(s -> s.getJddm().equals(mhSsBm.getZyywzdbmdm()) && s.getCj() == 1).findFirst().get();
                //一层
                BmSsYwlm bmSsYwlm1 = bmSsYwlmList.stream().filter(s -> s.getLmFid().equals(bmSsYwlm.getId())).findFirst().get();
                //二层
                BmSsYwlm bmSsYwlm2 = bmSsYwlmList.stream().filter(s -> s.getLmFid().equals(bmSsYwlm1.getId())).findFirst().get();
                //三层
                BmSsYwlm bmSsYwlm3 = bmSsYwlmList.stream().filter(s -> s.getLmFid().equals(bmSsYwlm2.getId())).findFirst().get();
                //二层
                BmSsYwlm bmSsYwlm4 = bmSsYwlmList.stream().filter(s -> s.getLmFid().equals(bmSsYwlm3.getId())).findFirst().get();
                bmSsYwlmMap.put(mhSsBm.getBmmc(), bmSsYwlm4.getId());
            }
        }
        for (Mlxx20230807 mlxx20230807 : mlxx20230807List) {
            BmSsMlxx bmSsMlxx = new BmSsMlxx();
            BeanUtils.copyProperties(mlxx20230807, bmSsMlxx);
            if (bmMap.containsKey(mlxx20230807.getSsbmmc())) {
                bmSsMlxx.setSsbmId(bmMap.get(mlxx20230807.getSsbmmc()).getId());
                bmSsMlxx.setSsbmmc(bmMap.get(mlxx20230807.getSsbmmc()).getBmmc());
                bmSsMlxx.setSsywlmId(bmSsYwlmMap.get(bmSsMlxx.getSsbmmc()));
                bmSsMlxx.setSsly("99");
                if(bmSsMlxx.getSsbmmc().contains("省")){
                    bmSsMlxx.setSjcj("2");
                }else {
                    bmSsMlxx.setSjcj("4");
                }
                bmSsMlxx.setMlfj("1");
                bmSsMlxx.setSjqyfw("4");
                bmSsMlxx.setMlmc(bmSsMlxx.getMlmc().contains("_")?bmSsMlxx.getMlmc().substring(bmSsMlxx.getMlmc().indexOf("_")+1):bmSsMlxx.getMlmc());
                bmSsMlxx.setMlmc(bmSsMlxx.getMlmc().contains("徐州")?bmSsMlxx.getMlmc().substring(bmSsMlxx.getMlmc().indexOf("徐州")+1):bmSsMlxx.getMlmc());
                //是否发布
                bmSsMlxx.setSffb("1");
                //时间范围
                bmSsMlxx.setSjsjfwJs("4089863244000");
                bmSsMlxx.setSjsjfwKs("1691485644000");
                //摘要
                bmSsMlxx.setMlms(StringUtils.isNotBlank(bmSsMlxx.getMlms())?bmSsMlxx.getMlms():bmSsMlxx.getMlmc());
                bmSsMlxx.setMlms(bmSsMlxx.getMlms().replace("徐州","").replace("沛县",""));
                bmSsMlxxService.save(bmSsMlxx);
            }
        }
        //end
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }

    @GetMapping("/mlxxx")
    @ApiOperation(value = "mlxxx", httpMethod = "GET", notes = "mlxxx", nickname = "mlxxx")
    public ResultMap<JSONObject> mlxxx() {
        long startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
        //start
        List<BmSsMlxx> bmSsMlxxList=bmSsMlxxService.list();
        for (BmSsMlxx bmSsMlxx:bmSsMlxxList){
            QueryWrapper<WdMlxxx20230807> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ML_ID",bmSsMlxx.getId());
            List<WdMlxxx20230807> wdMlxxx20230807List = wdMlxxx20230807Service.list(queryWrapper);
            int i=1;
            for (WdMlxxx20230807 wdMlxxx20230807:wdMlxxx20230807List){
                BmWdMlxxx wdMlxxx=new BmWdMlxxx();
                BeanUtils.copyProperties(wdMlxxx20230807,wdMlxxx);
                wdMlxxx.setXxxbm(String.format("%03d", i));
                i++;
                wdMlxxx.setKflx(bmSsMlxx.getKflx());
                wdMlxxx.setSjmgjb((StringUtils.isNotBlank(wdMlxxx.getSjmgjb())) ? "0"+wdMlxxx.getSjmgjb() : "02");
                wdMlxxx.setXxxlx(("字符型 C".equals(wdMlxxx.getXxxlx()) || "字符型C".equals(wdMlxxx.getXxxlx()))?"字符串型C":wdMlxxx.getXxxlx());
                bmWdMlxxxService.save(wdMlxxx);
            }
        }
        //end
        long endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        return ResultMap.resultSuccess("wait " + (endTimeMillis - startTimeMillis) + "ms");
    }
}
