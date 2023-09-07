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
@TableName("SS_MLXX20230807")
@ApiModel(value="Mlxx20230807对象", description="目录信息")
public class Mlxx20230807 implements Serializable {

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

    @ApiModelProperty(value = "资源类型(01:库表,02:文件,03:接口)")
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

    @ApiModelProperty(value = "前段码ID（类目表-部门的类目ID）")
    @TableField("QDM_ID")
    private String qdmId;

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

    @ApiModelProperty(value = "关联事项编码")
    @TableField("GLSXBM")
    private String glsxbm;

    @ApiModelProperty(value = "提供渠道")
    @TableField("TGQD")
    private String tgqd;

    @ApiModelProperty(value = "应用场景")
    @TableField("YYCJ")
    private String yycj;

    @ApiModelProperty(value = "其他应用场景")
    @TableField("QTYYCJ")
    private String qtyycj;

    @ApiModelProperty(value = "所属领域")
    @TableField("SSLY")
    private String ssly;

    @ApiModelProperty(value = "其他所属领域")
    @TableField("QTSSLY")
    private String qtssly;

    @ApiModelProperty(value = "政务服务数据提供方")
    @TableField("ZWFWSJTGF")
    private String zwfwsjtgf;

    @ApiModelProperty(value = "提供方代码")
    @TableField("TGFDM")
    private String tgfdm;

    @ApiModelProperty(value = "是否电子证照 1：是2：否")
    @TableField("SFDZZZ")
    private String sfdzzz;

    @ApiModelProperty(value = "资源所注册平台")
    @TableField("ZYSZCPT")
    private String zyszcpt;

    @ApiModelProperty(value = "是否已注册数据资源 1：是2：否")
    @TableField("SFYZCSJZY")
    private String sfyzcsjzy;

    @ApiModelProperty(value = "审批结果(关联事项办理产生的结果名称)，多个结果以|符号隔开，对应原型结果名称")
    @TableField("JGMC")
    private String jgmc;

    @ApiModelProperty(value = "数据所属事项")
    @TableField("SJSSSX")
    private String sjsssx;

    @ApiModelProperty(value = "实施清单编码")
    @TableField("SSQDBM")
    private String ssqdbm;

    @ApiModelProperty(value = "目录原名")
    @TableField("MLYM")
    private String mlym;

    @ApiModelProperty(value = "数据时间起")
    @TableField("SJSJQ")
    private String sjsjq;

    @ApiModelProperty(value = "数据时间止")
    @TableField("SJSJZ")
    private String sjsjz;

    @ApiModelProperty(value = "数据空间范围")
    @TableField("SJKJFW")
    private String sjkjfw;

    @ApiModelProperty(value = "原资源所注册平台（用于驳回后数据还原）")
    @TableField("YZYSZCPT")
    private String yzyszcpt;

    @ApiModelProperty(value = "资源申请隐藏标志  Y-隐藏 ")
    @TableField("SQYCBZ")
    private String sqycbz;

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
    public String getQdmId() {
        return qdmId;
    }

    public void setQdmId(String qdmId) {
        this.qdmId = qdmId;
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
    public String getGlsxbm() {
        return glsxbm;
    }

    public void setGlsxbm(String glsxbm) {
        this.glsxbm = glsxbm;
    }
    public String getTgqd() {
        return tgqd;
    }

    public void setTgqd(String tgqd) {
        this.tgqd = tgqd;
    }
    public String getYycj() {
        return yycj;
    }

    public void setYycj(String yycj) {
        this.yycj = yycj;
    }
    public String getQtyycj() {
        return qtyycj;
    }

    public void setQtyycj(String qtyycj) {
        this.qtyycj = qtyycj;
    }
    public String getSsly() {
        return ssly;
    }

    public void setSsly(String ssly) {
        this.ssly = ssly;
    }
    public String getQtssly() {
        return qtssly;
    }

    public void setQtssly(String qtssly) {
        this.qtssly = qtssly;
    }
    public String getZwfwsjtgf() {
        return zwfwsjtgf;
    }

    public void setZwfwsjtgf(String zwfwsjtgf) {
        this.zwfwsjtgf = zwfwsjtgf;
    }
    public String getTgfdm() {
        return tgfdm;
    }

    public void setTgfdm(String tgfdm) {
        this.tgfdm = tgfdm;
    }
    public String getSfdzzz() {
        return sfdzzz;
    }

    public void setSfdzzz(String sfdzzz) {
        this.sfdzzz = sfdzzz;
    }
    public String getZyszcpt() {
        return zyszcpt;
    }

    public void setZyszcpt(String zyszcpt) {
        this.zyszcpt = zyszcpt;
    }
    public String getSfyzcsjzy() {
        return sfyzcsjzy;
    }

    public void setSfyzcsjzy(String sfyzcsjzy) {
        this.sfyzcsjzy = sfyzcsjzy;
    }
    public String getJgmc() {
        return jgmc;
    }

    public void setJgmc(String jgmc) {
        this.jgmc = jgmc;
    }
    public String getSjsssx() {
        return sjsssx;
    }

    public void setSjsssx(String sjsssx) {
        this.sjsssx = sjsssx;
    }
    public String getSsqdbm() {
        return ssqdbm;
    }

    public void setSsqdbm(String ssqdbm) {
        this.ssqdbm = ssqdbm;
    }
    public String getMlym() {
        return mlym;
    }

    public void setMlym(String mlym) {
        this.mlym = mlym;
    }
    public String getSjsjq() {
        return sjsjq;
    }

    public void setSjsjq(String sjsjq) {
        this.sjsjq = sjsjq;
    }
    public String getSjsjz() {
        return sjsjz;
    }

    public void setSjsjz(String sjsjz) {
        this.sjsjz = sjsjz;
    }
    public String getSjkjfw() {
        return sjkjfw;
    }

    public void setSjkjfw(String sjkjfw) {
        this.sjkjfw = sjkjfw;
    }
    public String getYzyszcpt() {
        return yzyszcpt;
    }

    public void setYzyszcpt(String yzyszcpt) {
        this.yzyszcpt = yzyszcpt;
    }
    public String getSqycbz() {
        return sqycbz;
    }

    public void setSqycbz(String sqycbz) {
        this.sqycbz = sqycbz;
    }

    @Override
    public String toString() {
        return "Mlxx20230807{" +
            "id=" + id +
            ", mlmc=" + mlmc +
            ", mlbh=" + mlbh +
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
            ", qdmId=" + qdmId +
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
            ", sfsc=" + sfsc +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", bbh=" + bbh +
            ", glsxbm=" + glsxbm +
            ", tgqd=" + tgqd +
            ", yycj=" + yycj +
            ", qtyycj=" + qtyycj +
            ", ssly=" + ssly +
            ", qtssly=" + qtssly +
            ", zwfwsjtgf=" + zwfwsjtgf +
            ", tgfdm=" + tgfdm +
            ", sfdzzz=" + sfdzzz +
            ", zyszcpt=" + zyszcpt +
            ", sfyzcsjzy=" + sfyzcsjzy +
            ", jgmc=" + jgmc +
            ", sjsssx=" + sjsssx +
            ", ssqdbm=" + ssqdbm +
            ", mlym=" + mlym +
            ", sjsjq=" + sjsjq +
            ", sjsjz=" + sjsjz +
            ", sjkjfw=" + sjkjfw +
            ", yzyszcpt=" + yzyszcpt +
            ", sqycbz=" + sqycbz +
        "}";
    }
}
