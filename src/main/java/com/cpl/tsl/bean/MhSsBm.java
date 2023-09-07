package com.cpl.tsl.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author lll
 * @since 2023-08-07
 */
@TableName("MH_SS_BM")
@ApiModel(value="MhSsBm对象", description="部门表")
public class MhSsBm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "部门代码")
    @TableField("BMDM")
    private String bmdm;

    @ApiModelProperty(value = "部门名称")
    @TableField("BMMC")
    private String bmmc;

    @ApiModelProperty(value = "部门简称")
    @TableField("BMJC")
    private String bmjc;

    @ApiModelProperty(value = "标志")
    @TableField("BMBZ")
    private Integer bmbz;

    @ApiModelProperty(value = "上级部门代码")
    @TableField("SJBMDM")
    private String sjbmdm;

    @ApiModelProperty(value = "部门层级代码")
    @TableField("BMCJDM")
    private String bmcjdm;

    @ApiModelProperty(value = "邮政编码")
    @TableField("YZBM")
    private String yzbm;

    @ApiModelProperty(value = "地址")
    @TableField("BMDZ")
    private String bmdz;

    @ApiModelProperty(value = "联系电话")
    @TableField("BMDIANHUA")
    private String bmdianhua;

    @ApiModelProperty(value = "传真电话")
    @TableField("CZ")
    private String cz;

    @ApiModelProperty(value = "电子信箱")
    @TableField("DZXX")
    private String dzxx;

    @ApiModelProperty(value = "行政区划数字代码")
    @TableField("XZQHDM")
    private String xzqhdm;

    @ApiModelProperty(value = "负责人")
    @TableField("FZR")
    private String fzr;

    @ApiModelProperty(value = "有效标志(Y/N)")
    @TableField("YXBZ")
    private String yxbz;

    @ApiModelProperty(value = "关联资源组织空间 名称")
    @TableField("ZYZZKJMC")
    private String zyzzkjmc;

    @ApiModelProperty(value = "关联资源组织空间代码")
    @TableField("ZYZZKJDM")
    private String zyzzkjdm;

    @ApiModelProperty(value = "资源组织项目空间类型代码")
    @TableField("ZYZZKJLXDM")
    private String zyzzkjlxdm;

    @ApiModelProperty(value = "资源组织项目空间类型名称")
    @TableField("ZYZZKJLXMC")
    private String zyzzkjlxmc;

    @ApiModelProperty(value = "【部门类型】字段，01机关 02项目组")
    @TableField("BMLX")
    private String bmlx;

    @ApiModelProperty(value = "有效起始日期")
    @TableField("YXQKSRQ")
    private String yxqksrq;

    @ApiModelProperty(value = "有效终止日期")
    @TableField("YXQJSRQ")
    private String yxqjsrq;

    @ApiModelProperty(value = "部门描述")
    @TableField("BMMS")
    private String bmms;

    @ApiModelProperty(value = "是否删除(Y/N)")
    @TableField("SFSC")
    private String sfsc;

    @ApiModelProperty(value = "版本号")
    @TableField("BBH")
    private String bbh;

    @ApiModelProperty(value = "创建人id")
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

    @ApiModelProperty(value = "上级部门id")
    @TableField("SJBMID")
    private String sjbmid;

    @ApiModelProperty(value = "序号")
    @TableField("XH")
    private Integer xh;

    @ApiModelProperty(value = "数据来源")
    @TableField("SJLY")
    private String sjly;

    @ApiModelProperty(value = "统一社会信用代码")
    @TableField("TYSHXYDM")
    private String tyshxydm;

    @ApiModelProperty(value = "行政区划代码")
    @TableField("XZQHCODE")
    private String xzqhcode;

    @ApiModelProperty(value = "行政区划名称")
    @TableField("XZQHNAME")
    private String xzqhname;

    @ApiModelProperty(value = "上级国务院部门代码")
    @TableField("SJGWYBMDM")
    private String sjgwybmdm;

    @ApiModelProperty(value = "数据权限 1 本组织 2 同级组织 3 下级组织 用逗号隔开")
    @TableField("SJQX")
    private String sjqx;

    @ApiModelProperty(value = "组织层级(1 国家级，2 省级，3 市级，4 县（区）级)")
    @TableField("ZZCJ")
    private String zzcj;

    @ApiModelProperty(value = "虚拟组织(Y是虚拟组织，N非虚拟组织)")
    @TableField("XNZZ")
    private String xnzz;

    @ApiModelProperty(value = "中央业务指导部门代码")
    @TableField("ZYYWZDBMDM")
    private String zyywzdbmdm;

    @ApiModelProperty(value = "上级业务部门部门代码")
    @TableField("SJYWBMDM")
    private String sjywbmdm;

    @ApiModelProperty(value = "上级组织层级(1 国家级，2 省级，3 市级，4 县（区）级)")
    @TableField("SJZZCJ")
    private String sjzzcj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }
    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }
    public String getBmjc() {
        return bmjc;
    }

    public void setBmjc(String bmjc) {
        this.bmjc = bmjc;
    }
    public Integer getBmbz() {
        return bmbz;
    }

    public void setBmbz(Integer bmbz) {
        this.bmbz = bmbz;
    }
    public String getSjbmdm() {
        return sjbmdm;
    }

    public void setSjbmdm(String sjbmdm) {
        this.sjbmdm = sjbmdm;
    }
    public String getBmcjdm() {
        return bmcjdm;
    }

    public void setBmcjdm(String bmcjdm) {
        this.bmcjdm = bmcjdm;
    }
    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }
    public String getBmdz() {
        return bmdz;
    }

    public void setBmdz(String bmdz) {
        this.bmdz = bmdz;
    }
    public String getBmdianhua() {
        return bmdianhua;
    }

    public void setBmdianhua(String bmdianhua) {
        this.bmdianhua = bmdianhua;
    }
    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }
    public String getDzxx() {
        return dzxx;
    }

    public void setDzxx(String dzxx) {
        this.dzxx = dzxx;
    }
    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }
    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }
    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }
    public String getZyzzkjmc() {
        return zyzzkjmc;
    }

    public void setZyzzkjmc(String zyzzkjmc) {
        this.zyzzkjmc = zyzzkjmc;
    }
    public String getZyzzkjdm() {
        return zyzzkjdm;
    }

    public void setZyzzkjdm(String zyzzkjdm) {
        this.zyzzkjdm = zyzzkjdm;
    }
    public String getZyzzkjlxdm() {
        return zyzzkjlxdm;
    }

    public void setZyzzkjlxdm(String zyzzkjlxdm) {
        this.zyzzkjlxdm = zyzzkjlxdm;
    }
    public String getZyzzkjlxmc() {
        return zyzzkjlxmc;
    }

    public void setZyzzkjlxmc(String zyzzkjlxmc) {
        this.zyzzkjlxmc = zyzzkjlxmc;
    }
    public String getBmlx() {
        return bmlx;
    }

    public void setBmlx(String bmlx) {
        this.bmlx = bmlx;
    }
    public String getYxqksrq() {
        return yxqksrq;
    }

    public void setYxqksrq(String yxqksrq) {
        this.yxqksrq = yxqksrq;
    }
    public String getYxqjsrq() {
        return yxqjsrq;
    }

    public void setYxqjsrq(String yxqjsrq) {
        this.yxqjsrq = yxqjsrq;
    }
    public String getBmms() {
        return bmms;
    }

    public void setBmms(String bmms) {
        this.bmms = bmms;
    }
    public String getSfsc() {
        return sfsc;
    }

    public void setSfsc(String sfsc) {
        this.sfsc = sfsc;
    }
    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
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
    public String getSjbmid() {
        return sjbmid;
    }

    public void setSjbmid(String sjbmid) {
        this.sjbmid = sjbmid;
    }
    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }
    public String getSjly() {
        return sjly;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }
    public String getTyshxydm() {
        return tyshxydm;
    }

    public void setTyshxydm(String tyshxydm) {
        this.tyshxydm = tyshxydm;
    }
    public String getXzqhcode() {
        return xzqhcode;
    }

    public void setXzqhcode(String xzqhcode) {
        this.xzqhcode = xzqhcode;
    }
    public String getXzqhname() {
        return xzqhname;
    }

    public void setXzqhname(String xzqhname) {
        this.xzqhname = xzqhname;
    }
    public String getSjgwybmdm() {
        return sjgwybmdm;
    }

    public void setSjgwybmdm(String sjgwybmdm) {
        this.sjgwybmdm = sjgwybmdm;
    }
    public String getSjqx() {
        return sjqx;
    }

    public void setSjqx(String sjqx) {
        this.sjqx = sjqx;
    }
    public String getZzcj() {
        return zzcj;
    }

    public void setZzcj(String zzcj) {
        this.zzcj = zzcj;
    }
    public String getXnzz() {
        return xnzz;
    }

    public void setXnzz(String xnzz) {
        this.xnzz = xnzz;
    }
    public String getZyywzdbmdm() {
        return zyywzdbmdm;
    }

    public void setZyywzdbmdm(String zyywzdbmdm) {
        this.zyywzdbmdm = zyywzdbmdm;
    }
    public String getSjywbmdm() {
        return sjywbmdm;
    }

    public void setSjywbmdm(String sjywbmdm) {
        this.sjywbmdm = sjywbmdm;
    }
    public String getSjzzcj() {
        return sjzzcj;
    }

    public void setSjzzcj(String sjzzcj) {
        this.sjzzcj = sjzzcj;
    }

    @Override
    public String toString() {
        return "MhSsBm{" +
            "id=" + id +
            ", bmdm=" + bmdm +
            ", bmmc=" + bmmc +
            ", bmjc=" + bmjc +
            ", bmbz=" + bmbz +
            ", sjbmdm=" + sjbmdm +
            ", bmcjdm=" + bmcjdm +
            ", yzbm=" + yzbm +
            ", bmdz=" + bmdz +
            ", bmdianhua=" + bmdianhua +
            ", cz=" + cz +
            ", dzxx=" + dzxx +
            ", xzqhdm=" + xzqhdm +
            ", fzr=" + fzr +
            ", yxbz=" + yxbz +
            ", zyzzkjmc=" + zyzzkjmc +
            ", zyzzkjdm=" + zyzzkjdm +
            ", zyzzkjlxdm=" + zyzzkjlxdm +
            ", zyzzkjlxmc=" + zyzzkjlxmc +
            ", bmlx=" + bmlx +
            ", yxqksrq=" + yxqksrq +
            ", yxqjsrq=" + yxqjsrq +
            ", bmms=" + bmms +
            ", sfsc=" + sfsc +
            ", bbh=" + bbh +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", sjbmid=" + sjbmid +
            ", xh=" + xh +
            ", sjly=" + sjly +
            ", tyshxydm=" + tyshxydm +
            ", xzqhcode=" + xzqhcode +
            ", xzqhname=" + xzqhname +
            ", sjgwybmdm=" + sjgwybmdm +
            ", sjqx=" + sjqx +
            ", zzcj=" + zzcj +
            ", xnzz=" + xnzz +
            ", zyywzdbmdm=" + zyywzdbmdm +
            ", sjywbmdm=" + sjywbmdm +
            ", sjzzcj=" + sjzzcj +
        "}";
    }
}
