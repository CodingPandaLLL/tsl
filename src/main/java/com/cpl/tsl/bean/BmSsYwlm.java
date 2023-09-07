package com.cpl.tsl.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 类目信息
 * </p>
 *
 * @author lll
 * @since 2023-08-07
 */
@TableName("BM_SS_YWLM")
@ApiModel(value="BmSsYwlm对象", description="类目信息")
public class BmSsYwlm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "类目名称")
    @TableField("LMMC")
    private String lmmc;

    @ApiModelProperty(value = "目录简称")
    @TableField("LMJC")
    private String lmjc;

    @ApiModelProperty(value = "类目图标")
    @TableField("LMTB")
    private String lmtb;

    @ApiModelProperty(value = "类目背景")
    @TableField("LMBJ")
    private String lmbj;

    @ApiModelProperty(value = "节点代码")
    @TableField("JDDM")
    private String jddm;

    @ApiModelProperty(value = "类目编号")
    @TableField("LMBH")
    private String lmbh;

    @ApiModelProperty(value = "类目状态 01:已上线 02:已下线，03待发布")
    @TableField("LMZT")
    private String lmzt;

    @ApiModelProperty(value = "类目描述")
    @TableField("LMMS")
    private String lmms;

    @ApiModelProperty(value = "父级类目ID")
    @TableField("LM_FID")
    private String lmFid;

    @ApiModelProperty(value = "排序号")
    @TableField("PXH")
    private Integer pxh;

    @ApiModelProperty(value = "层级")
    @TableField("CJ")
    private Integer cj;

    @ApiModelProperty(value = "类目编号关系")
    @TableField("LMBHGX")
    private String lmbhgx;

    @ApiModelProperty(value = "是否初始化(Y/N)")
    @TableField("SFCSH")
    private String sfcsh;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getLmmc() {
        return lmmc;
    }

    public void setLmmc(String lmmc) {
        this.lmmc = lmmc;
    }
    public String getLmjc() {
        return lmjc;
    }

    public void setLmjc(String lmjc) {
        this.lmjc = lmjc;
    }
    public String getLmtb() {
        return lmtb;
    }

    public void setLmtb(String lmtb) {
        this.lmtb = lmtb;
    }
    public String getLmbj() {
        return lmbj;
    }

    public void setLmbj(String lmbj) {
        this.lmbj = lmbj;
    }
    public String getJddm() {
        return jddm;
    }

    public void setJddm(String jddm) {
        this.jddm = jddm;
    }
    public String getLmbh() {
        return lmbh;
    }

    public void setLmbh(String lmbh) {
        this.lmbh = lmbh;
    }
    public String getLmzt() {
        return lmzt;
    }

    public void setLmzt(String lmzt) {
        this.lmzt = lmzt;
    }
    public String getLmms() {
        return lmms;
    }

    public void setLmms(String lmms) {
        this.lmms = lmms;
    }
    public String getLmFid() {
        return lmFid;
    }

    public void setLmFid(String lmFid) {
        this.lmFid = lmFid;
    }
    public Integer getPxh() {
        return pxh;
    }

    public void setPxh(Integer pxh) {
        this.pxh = pxh;
    }
    public Integer getCj() {
        return cj;
    }

    public void setCj(Integer cj) {
        this.cj = cj;
    }
    public String getLmbhgx() {
        return lmbhgx;
    }

    public void setLmbhgx(String lmbhgx) {
        this.lmbhgx = lmbhgx;
    }
    public String getSfcsh() {
        return sfcsh;
    }

    public void setSfcsh(String sfcsh) {
        this.sfcsh = sfcsh;
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

    @Override
    public String toString() {
        return "BmSsYwlm{" +
            "id=" + id +
            ", lmmc=" + lmmc +
            ", lmjc=" + lmjc +
            ", lmtb=" + lmtb +
            ", lmbj=" + lmbj +
            ", jddm=" + jddm +
            ", lmbh=" + lmbh +
            ", lmzt=" + lmzt +
            ", lmms=" + lmms +
            ", lmFid=" + lmFid +
            ", pxh=" + pxh +
            ", cj=" + cj +
            ", lmbhgx=" + lmbhgx +
            ", sfcsh=" + sfcsh +
            ", sfsc=" + sfsc +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", bbh=" + bbh +
        "}";
    }
}
