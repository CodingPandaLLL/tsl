package com.cpl.tsl.bean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 目录信息
 * </p>
 *
 * @author lll
 * @since 2023-08-07
 */
@TableName("BM_SS_MLXX")
@ApiModel(value="BmSsMlxx对象", description="目录信息")
public class BmSsMlxx implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "目录名称")
    @TableField("MLMC")
    private String mlmc;

    @ApiModelProperty(value = "目录编号")
    @TableField("MLBH")
    private String mlbh;

    @ApiModelProperty(value = "业务目录编号")
    @TableField("YWMLBH")
    private String ywmlbh;

    @ApiModelProperty(value = "目录状态, 01:待提交 02:待审核 03:已发布 04:下线中 05:已下线 06:待发布 07:已退回")
    @TableField("MLZT")
    private String mlzt;

    @ApiModelProperty(value = "目录描述")
    @TableField("MLMS")
    private String mlms;

    @ApiModelProperty(value = "挂载说明")
    @TableField("GZSM")
    private String gzsm;

    @ApiModelProperty(value = "来源系统ID")
    @TableField("LYXT_ID")
    private String lyxtId;

    @ApiModelProperty(value = "系统所属分类字段(01垂管系统 02自建系统)")
    @TableField("XTSSFL")
    private String xtssfl;

    @ApiModelProperty(value = "所属部门ID")
    @TableField("SSBM_ID")
    private String ssbmId;

    @ApiModelProperty(value = "所属部门名称")
    @TableField("SSBMMC")
    private String ssbmmc;

    @ApiModelProperty(value = "数据资源类型, 逗号分隔，")
    @TableField("ZYLX")
    private String zylx;

    @ApiModelProperty(value = "资源格式 01:mysql 02:SQLServer 03:oracle 06:Hive（同数据源表维护的类型）")
    @TableField("ZYGS")
    private String zygs;

    @ApiModelProperty(value = "更新周期（01每日 02每周 03每月 04每季度 05每年 06半年 07实时）")
    @TableField("GXZQ")
    private String gxzq;

    @ApiModelProperty(value = "所属基础类目")
    @TableField("SSJCLM_ID")
    private String ssjclmId;

    @ApiModelProperty(value = "所属主题类目")
    @TableField("SSZTLM_ID")
    private String ssztlmId;

    @ApiModelProperty(value = "所属其他类目")
    @TableField("SSQTLM_ID")
    private String ssqtlmId;

    @ApiModelProperty(value = "所属业务类目ID")
    @TableField("SSYWLM_ID")
    private String ssywlmId;

    @ApiModelProperty(value = "前段码ID（类目表-部门的类目ID）")
    @TableField("QDM_ID")
    private String qdmId;

    @ApiModelProperty(value = "数据所在层级，逗号分隔")
    @TableField("SJCJ")
    private String sjcj;

    @ApiModelProperty(value = "数据所属领域,逗号分隔")
    @TableField("SSLY")
    private String ssly;

    @ApiModelProperty(value = "数据来源事项ID")
    @TableField("LYSX_ID")
    private String lysxId;

    @ApiModelProperty(value = "是否已注册数据资源(Y/N)")
    @TableField("SFYZZZY")
    private String sfyzzzy;

    @ApiModelProperty(value = "数据资源所注册的平台")
    @TableField("SJZYZZPT")
    private String sjzyzzpt;

    @ApiModelProperty(value = "开放类型（01:有条件开放，02:无条件开放，03:完全不开放）")
    @TableField("KFLX")
    private String kflx;

    @ApiModelProperty(value = "开放条件")
    @TableField("KFTJ")
    private String kftj;

    @ApiModelProperty(value = "共享类型（01:有条件共享，02:无条件共享，03:不予共享）")
    @TableField("GXLX")
    private String gxlx;

    @ApiModelProperty(value = "配置信息项方式 01:数据表 02:自定义")
    @TableField("PZXXXFS")
    private String pzxxxfs;

    @ApiModelProperty(value = "共享条件")
    @TableField("GXTJ")
    private String gxtj;

    @ApiModelProperty(value = "数据存储总量(GB)")
    @TableField("SJCCZL")
    private BigDecimal sjcczl;

    @ApiModelProperty(value = "结构化信息记录总条数(万条)")
    @TableField("JGHXXJLS")
    private BigDecimal jghxxjls;

    @ApiModelProperty(value = "已共享数据存储量(GB)")
    @TableField("YGXSJCCL")
    private BigDecimal ygxsjccl;

    @ApiModelProperty(value = "已共享结构化信息记录数(万条)")
    @TableField("YGXJGHJLS")
    private BigDecimal ygxjghjls;

    @ApiModelProperty(value = "已开放数据存储量(GB)")
    @TableField("YKFSJCCL")
    private BigDecimal ykfsjccl;

    @ApiModelProperty(value = "已开放结构化信息记录数(万条)")
    @TableField("YKFJGHJLS")
    private BigDecimal ykfjghjls;

    @ApiModelProperty(value = "资源挂载状态, 01:未挂接 02:挂接待审核 03:挂接已退回 04:已挂接 05:变更待审核")
    @TableField("ZYGZZT")
    private String zygzzt;

    @ApiModelProperty(value = "挂载资源ID")
    @TableField("ZYXX_ID")
    private String zyxxId;

    @ApiModelProperty(value = "申请数量")
    @TableField("SQSL")
    private Integer sqsl;

    @ApiModelProperty(value = "浏览数量")
    @TableField("LLSL")
    private Integer llsl;

    @ApiModelProperty(value = "开放平台-申请数量")
    @TableField("KFPTSQSL")
    private Integer kfptsqsl;

    @ApiModelProperty(value = "开放平台-浏览数量")
    @TableField("KFPTLLSL")
    private Integer kfptllsl;

    @ApiModelProperty(value = "开放平台-资源评分")
    @TableField("KFPTZYPF")
    private BigDecimal kfptzypf;

    @ApiModelProperty(value = "发布时间")
    @TableField("FBSJ")
    private String fbsj;

    @ApiModelProperty(value = "目录版本号")
    @TableField("MLBBH")
    private Integer mlbbh;

    @ApiModelProperty(value = "有效标志（Y/N 有效/无效）")
    @TableField("YXBZ")
    private String yxbz;

    @ApiModelProperty(value = "过程有效标志（Y/N 有效/无效）")
    @TableField("GCYXBZ")
    private String gcyxbz;

    @ApiModelProperty(value = "目录MD5值（基础信息+信息项）")
    @TableField("MD5")
    private String md5;

    @ApiModelProperty(value = "应用场景(01:政务服务 02:公共服务 03:监管 04:其他)")
    @TableField("YYCJ")
    private String yycj;

    @ApiModelProperty(value = "其他应用场景描述(应用场景填“其他”时的描述)")
    @TableField("QTYYCJMS")
    private String qtyycjms;

    @ApiModelProperty(value = "提供渠道(01:政务外网 02:互联网 03:部门专网)")
    @TableField("TGQD")
    private String tgqd;

    @ApiModelProperty(value = "是否电子证照(Y/N)")
    @TableField("SFDZZZ")
    private String sfdzzz;

    @ApiModelProperty(value = "目录类型(01:与政务服务事项相关联 02:其他)")
    @TableField("MLLX")
    private String mllx;

    @ApiModelProperty(value = "关联政务服务事项ID(多个事项ID间逗号分隔)")
    @TableField("GLSX_ID")
    private String glsxId;

    @ApiModelProperty(value = "是否删除(Y/N)")
    @TableField("SFSC")
    private String sfsc;

    @ApiModelProperty(value = "创建人ID")
    @TableField("CJR_ID")
    private String cjrId;

    @ApiModelProperty(value = "创建时间")
    @TableField("CJSJ")
    private String cjsj;

    @ApiModelProperty(value = "修改人ID")
    @TableField("XGR_ID")
    private String xgrId;

    @ApiModelProperty(value = "修改时间")
    @TableField("XGSJ")
    private String xgsj;

    @ApiModelProperty(value = "版本号")
    @TableField("BBH")
    private String bbh;

    @ApiModelProperty(value = "关联自动编目目录信息ID(有则是通过自动编目提交而来)")
    @TableField("ZDBMMLXX_ID")
    private String zdbmmlxxId;

    @ApiModelProperty(value = "自动编目-是否自动挂接：Y-是/N-否")
    @TableField("SFZDGJ")
    private String sfzdgj;

    @ApiModelProperty(value = "目录分级")
    @TableField("MLFJ")
    private String mlfj;

    @ApiModelProperty(value = "数据加工程度")
    @TableField("SJJGCD")
    private String sjjgcd;

    @ApiModelProperty(value = "数据区域范围")
    @TableField("SJQYFW")
    private String sjqyfw;

    @ApiModelProperty(value = "数据时间范围，开始时间")
    @TableField("SJSJFW_KS")
    private String sjsjfwKs;

    @ApiModelProperty(value = "数据时间范围，结束时间")
    @TableField("SJSJFW_JS")
    private String sjsjfwJs;

    @ApiModelProperty(value = "是否发布,Y 是 N 否")
    @TableField("SFFB")
    private String sffb;

    @ApiModelProperty(value = "数据来源事项实施清单名称(多个事项名称间逗号分隔)")
    @TableField("LYSXSSQD")
    private String lysxssqd;

    @ApiModelProperty(value = "数据来源事项业务项名称(多个业务项名称间逗号分隔)")
    @TableField("LYSXYWX")
    private String lysxywx;

    @ApiModelProperty(value = "目录来源")
    @TableField("MLLY")
    private String mlly;

    @ApiModelProperty(value = "三定职能ID")
    @TableField("SDZN_ID")
    private String sdznId;

    @ApiModelProperty(value = "业务事项名称")
    @TableField("SDZN_YWSXMC")
    private String sdznYwsxmc;

    @ApiModelProperty(value = "其他更新周期")
    @TableField("QTGXZQ")
    private String qtgxzq;

    @ApiModelProperty(value = "不发布理由")
    @TableField("BFBLY")
    private String bfbly;

    @ApiModelProperty(value = "目录性质(02认领目录，其他为自有目录)")
    @TableField("MLXZ")
    private String mlxz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMlmc() {
        return mlmc;
    }

    public void setMlmc(String mlmc) {
        this.mlmc = mlmc;
    }
    public String getMlbh() {
        return mlbh;
    }

    public void setMlbh(String mlbh) {
        this.mlbh = mlbh;
    }
    public String getYwmlbh() {
        return ywmlbh;
    }

    public void setYwmlbh(String ywmlbh) {
        this.ywmlbh = ywmlbh;
    }
    public String getMlzt() {
        return mlzt;
    }

    public void setMlzt(String mlzt) {
        this.mlzt = mlzt;
    }
    public String getMlms() {
        return mlms;
    }

    public void setMlms(String mlms) {
        this.mlms = mlms;
    }
    public String getGzsm() {
        return gzsm;
    }

    public void setGzsm(String gzsm) {
        this.gzsm = gzsm;
    }
    public String getLyxtId() {
        return lyxtId;
    }

    public void setLyxtId(String lyxtId) {
        this.lyxtId = lyxtId;
    }
    public String getXtssfl() {
        return xtssfl;
    }

    public void setXtssfl(String xtssfl) {
        this.xtssfl = xtssfl;
    }
    public String getSsbmId() {
        return ssbmId;
    }

    public void setSsbmId(String ssbmId) {
        this.ssbmId = ssbmId;
    }
    public String getSsbmmc() {
        return ssbmmc;
    }

    public void setSsbmmc(String ssbmmc) {
        this.ssbmmc = ssbmmc;
    }
    public String getZylx() {
        return zylx;
    }

    public void setZylx(String zylx) {
        this.zylx = zylx;
    }
    public String getZygs() {
        return zygs;
    }

    public void setZygs(String zygs) {
        this.zygs = zygs;
    }
    public String getGxzq() {
        return gxzq;
    }

    public void setGxzq(String gxzq) {
        this.gxzq = gxzq;
    }
    public String getSsjclmId() {
        return ssjclmId;
    }

    public void setSsjclmId(String ssjclmId) {
        this.ssjclmId = ssjclmId;
    }
    public String getSsztlmId() {
        return ssztlmId;
    }

    public void setSsztlmId(String ssztlmId) {
        this.ssztlmId = ssztlmId;
    }
    public String getSsqtlmId() {
        return ssqtlmId;
    }

    public void setSsqtlmId(String ssqtlmId) {
        this.ssqtlmId = ssqtlmId;
    }
    public String getSsywlmId() {
        return ssywlmId;
    }

    public void setSsywlmId(String ssywlmId) {
        this.ssywlmId = ssywlmId;
    }
    public String getQdmId() {
        return qdmId;
    }

    public void setQdmId(String qdmId) {
        this.qdmId = qdmId;
    }
    public String getSjcj() {
        return sjcj;
    }

    public void setSjcj(String sjcj) {
        this.sjcj = sjcj;
    }
    public String getSsly() {
        return ssly;
    }

    public void setSsly(String ssly) {
        this.ssly = ssly;
    }
    public String getLysxId() {
        return lysxId;
    }

    public void setLysxId(String lysxId) {
        this.lysxId = lysxId;
    }
    public String getSfyzzzy() {
        return sfyzzzy;
    }

    public void setSfyzzzy(String sfyzzzy) {
        this.sfyzzzy = sfyzzzy;
    }
    public String getSjzyzzpt() {
        return sjzyzzpt;
    }

    public void setSjzyzzpt(String sjzyzzpt) {
        this.sjzyzzpt = sjzyzzpt;
    }
    public String getKflx() {
        return kflx;
    }

    public void setKflx(String kflx) {
        this.kflx = kflx;
    }
    public String getKftj() {
        return kftj;
    }

    public void setKftj(String kftj) {
        this.kftj = kftj;
    }
    public String getGxlx() {
        return gxlx;
    }

    public void setGxlx(String gxlx) {
        this.gxlx = gxlx;
    }
    public String getPzxxxfs() {
        return pzxxxfs;
    }

    public void setPzxxxfs(String pzxxxfs) {
        this.pzxxxfs = pzxxxfs;
    }
    public String getGxtj() {
        return gxtj;
    }

    public void setGxtj(String gxtj) {
        this.gxtj = gxtj;
    }
    public BigDecimal getSjcczl() {
        return sjcczl;
    }

    public void setSjcczl(BigDecimal sjcczl) {
        this.sjcczl = sjcczl;
    }
    public BigDecimal getJghxxjls() {
        return jghxxjls;
    }

    public void setJghxxjls(BigDecimal jghxxjls) {
        this.jghxxjls = jghxxjls;
    }
    public BigDecimal getYgxsjccl() {
        return ygxsjccl;
    }

    public void setYgxsjccl(BigDecimal ygxsjccl) {
        this.ygxsjccl = ygxsjccl;
    }
    public BigDecimal getYgxjghjls() {
        return ygxjghjls;
    }

    public void setYgxjghjls(BigDecimal ygxjghjls) {
        this.ygxjghjls = ygxjghjls;
    }
    public BigDecimal getYkfsjccl() {
        return ykfsjccl;
    }

    public void setYkfsjccl(BigDecimal ykfsjccl) {
        this.ykfsjccl = ykfsjccl;
    }
    public BigDecimal getYkfjghjls() {
        return ykfjghjls;
    }

    public void setYkfjghjls(BigDecimal ykfjghjls) {
        this.ykfjghjls = ykfjghjls;
    }
    public String getZygzzt() {
        return zygzzt;
    }

    public void setZygzzt(String zygzzt) {
        this.zygzzt = zygzzt;
    }
    public String getZyxxId() {
        return zyxxId;
    }

    public void setZyxxId(String zyxxId) {
        this.zyxxId = zyxxId;
    }
    public Integer getSqsl() {
        return sqsl;
    }

    public void setSqsl(Integer sqsl) {
        this.sqsl = sqsl;
    }
    public Integer getLlsl() {
        return llsl;
    }

    public void setLlsl(Integer llsl) {
        this.llsl = llsl;
    }
    public Integer getKfptsqsl() {
        return kfptsqsl;
    }

    public void setKfptsqsl(Integer kfptsqsl) {
        this.kfptsqsl = kfptsqsl;
    }
    public Integer getKfptllsl() {
        return kfptllsl;
    }

    public void setKfptllsl(Integer kfptllsl) {
        this.kfptllsl = kfptllsl;
    }
    public BigDecimal getKfptzypf() {
        return kfptzypf;
    }

    public void setKfptzypf(BigDecimal kfptzypf) {
        this.kfptzypf = kfptzypf;
    }
    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }
    public Integer getMlbbh() {
        return mlbbh;
    }

    public void setMlbbh(Integer mlbbh) {
        this.mlbbh = mlbbh;
    }
    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }
    public String getGcyxbz() {
        return gcyxbz;
    }

    public void setGcyxbz(String gcyxbz) {
        this.gcyxbz = gcyxbz;
    }
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
    public String getYycj() {
        return yycj;
    }

    public void setYycj(String yycj) {
        this.yycj = yycj;
    }
    public String getQtyycjms() {
        return qtyycjms;
    }

    public void setQtyycjms(String qtyycjms) {
        this.qtyycjms = qtyycjms;
    }
    public String getTgqd() {
        return tgqd;
    }

    public void setTgqd(String tgqd) {
        this.tgqd = tgqd;
    }
    public String getSfdzzz() {
        return sfdzzz;
    }

    public void setSfdzzz(String sfdzzz) {
        this.sfdzzz = sfdzzz;
    }
    public String getMllx() {
        return mllx;
    }

    public void setMllx(String mllx) {
        this.mllx = mllx;
    }
    public String getGlsxId() {
        return glsxId;
    }

    public void setGlsxId(String glsxId) {
        this.glsxId = glsxId;
    }
    public String getSfsc() {
        return sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }
    public String getCjrId() {
        return cjrId;
    }

    public void setCjrId(String cjrId) {
        this.cjrId = cjrId;
    }
    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }
    public String getXgrId() {
        return xgrId;
    }

    public void setXgrId(String xgrId) {
        this.xgrId = xgrId;
    }
    public String getXgsj() {
        return xgsj;
    }

    public void setXgsj(String xgsj) {
        this.xgsj = xgsj;
    }
    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }
    public String getZdbmmlxxId() {
        return zdbmmlxxId;
    }

    public void setZdbmmlxxId(String zdbmmlxxId) {
        this.zdbmmlxxId = zdbmmlxxId;
    }
    public String getSfzdgj() {
        return sfzdgj;
    }

    public void setSfzdgj(String sfzdgj) {
        this.sfzdgj = sfzdgj;
    }
    public String getMlfj() {
        return mlfj;
    }

    public void setMlfj(String mlfj) {
        this.mlfj = mlfj;
    }
    public String getSjjgcd() {
        return sjjgcd;
    }

    public void setSjjgcd(String sjjgcd) {
        this.sjjgcd = sjjgcd;
    }
    public String getSjqyfw() {
        return sjqyfw;
    }

    public void setSjqyfw(String sjqyfw) {
        this.sjqyfw = sjqyfw;
    }
    public String getSjsjfwKs() {
        return sjsjfwKs;
    }

    public void setSjsjfwKs(String sjsjfwKs) {
        this.sjsjfwKs = sjsjfwKs;
    }
    public String getSjsjfwJs() {
        return sjsjfwJs;
    }

    public void setSjsjfwJs(String sjsjfwJs) {
        this.sjsjfwJs = sjsjfwJs;
    }
    public String getSffb() {
        return sffb;
    }

    public void setSffb(String sffb) {
        this.sffb = sffb;
    }
    public String getLysxssqd() {
        return lysxssqd;
    }

    public void setLysxssqd(String lysxssqd) {
        this.lysxssqd = lysxssqd;
    }
    public String getLysxywx() {
        return lysxywx;
    }

    public void setLysxywx(String lysxywx) {
        this.lysxywx = lysxywx;
    }
    public String getMlly() {
        return mlly;
    }

    public void setMlly(String mlly) {
        this.mlly = mlly;
    }
    public String getSdznId() {
        return sdznId;
    }

    public void setSdznId(String sdznId) {
        this.sdznId = sdznId;
    }
    public String getSdznYwsxmc() {
        return sdznYwsxmc;
    }

    public void setSdznYwsxmc(String sdznYwsxmc) {
        this.sdznYwsxmc = sdznYwsxmc;
    }
    public String getQtgxzq() {
        return qtgxzq;
    }

    public void setQtgxzq(String qtgxzq) {
        this.qtgxzq = qtgxzq;
    }
    public String getBfbly() {
        return bfbly;
    }

    public void setBfbly(String bfbly) {
        this.bfbly = bfbly;
    }
    public String getMlxz() {
        return mlxz;
    }

    public void setMlxz(String mlxz) {
        this.mlxz = mlxz;
    }

    @Override
    public String toString() {
        return "BmSsMlxx{" +
            "id=" + id +
            ", mlmc=" + mlmc +
            ", mlbh=" + mlbh +
            ", ywmlbh=" + ywmlbh +
            ", mlzt=" + mlzt +
            ", mlms=" + mlms +
            ", gzsm=" + gzsm +
            ", lyxtId=" + lyxtId +
            ", xtssfl=" + xtssfl +
            ", ssbmId=" + ssbmId +
            ", ssbmmc=" + ssbmmc +
            ", zylx=" + zylx +
            ", zygs=" + zygs +
            ", gxzq=" + gxzq +
            ", ssjclmId=" + ssjclmId +
            ", ssztlmId=" + ssztlmId +
            ", ssqtlmId=" + ssqtlmId +
            ", ssywlmId=" + ssywlmId +
            ", qdmId=" + qdmId +
            ", sjcj=" + sjcj +
            ", ssly=" + ssly +
            ", lysxId=" + lysxId +
            ", sfyzzzy=" + sfyzzzy +
            ", sjzyzzpt=" + sjzyzzpt +
            ", kflx=" + kflx +
            ", kftj=" + kftj +
            ", gxlx=" + gxlx +
            ", pzxxxfs=" + pzxxxfs +
            ", gxtj=" + gxtj +
            ", sjcczl=" + sjcczl +
            ", jghxxjls=" + jghxxjls +
            ", ygxsjccl=" + ygxsjccl +
            ", ygxjghjls=" + ygxjghjls +
            ", ykfsjccl=" + ykfsjccl +
            ", ykfjghjls=" + ykfjghjls +
            ", zygzzt=" + zygzzt +
            ", zyxxId=" + zyxxId +
            ", sqsl=" + sqsl +
            ", llsl=" + llsl +
            ", kfptsqsl=" + kfptsqsl +
            ", kfptllsl=" + kfptllsl +
            ", kfptzypf=" + kfptzypf +
            ", fbsj=" + fbsj +
            ", mlbbh=" + mlbbh +
            ", yxbz=" + yxbz +
            ", gcyxbz=" + gcyxbz +
            ", md5=" + md5 +
            ", yycj=" + yycj +
            ", qtyycjms=" + qtyycjms +
            ", tgqd=" + tgqd +
            ", sfdzzz=" + sfdzzz +
            ", mllx=" + mllx +
            ", glsxId=" + glsxId +
            ", sfsc=" + sfsc +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", bbh=" + bbh +
            ", zdbmmlxxId=" + zdbmmlxxId +
            ", sfzdgj=" + sfzdgj +
            ", mlfj=" + mlfj +
            ", sjjgcd=" + sjjgcd +
            ", sjqyfw=" + sjqyfw +
            ", sjsjfwKs=" + sjsjfwKs +
            ", sjsjfwJs=" + sjsjfwJs +
            ", sffb=" + sffb +
            ", lysxssqd=" + lysxssqd +
            ", lysxywx=" + lysxywx +
            ", mlly=" + mlly +
            ", sdznId=" + sdznId +
            ", sdznYwsxmc=" + sdznYwsxmc +
            ", qtgxzq=" + qtgxzq +
            ", bfbly=" + bfbly +
            ", mlxz=" + mlxz +
        "}";
    }
}
