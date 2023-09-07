package com.cpl.tsl.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 目录信息项
 * </p>
 *
 * @author lll
 * @since 2023-08-07
 */
@TableName("WD_MLXXX20230807")
@ApiModel(value="WdMlxxx20230807对象", description="目录信息项")
public class WdMlxxx20230807 implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "信息项编码")
    @TableField("XXXBM")
    private String xxxbm;

    @ApiModelProperty(value = "目录ID")
    @TableField("ML_ID")
    private String mlId;

    @ApiModelProperty(value = "代码集ID")
    @TableField("DMJ_ID")
    private String dmjId;

    @ApiModelProperty(value = "信息项中文名")
    @TableField("XXXZWM")
    private String xxxzwm;

    @ApiModelProperty(value = "信息项英文名")
    @TableField("XXXYWM")
    private String xxxywm;

    @ApiModelProperty(value = "信息项描述")
    @TableField("XXXMS")
    private String xxxms;

    @ApiModelProperty(value = "信息项类型")
    @TableField("XXXLX")
    private String xxxlx;

    @ApiModelProperty(value = "开放类型（01:有条件开放，02:无条件开放，03:完全不开放）")
    @TableField("KFLX")
    private String kflx;

    @ApiModelProperty(value = "是否主键(Y/N)")
    @TableField("SFZJ")
    private String sfzj;

    @ApiModelProperty(value = "是否可空(Y/N)")
    @TableField("SFKK")
    private String sfkk;

    @ApiModelProperty(value = "共享类型（01:有条件共享，02:无条件共享，03:不予共享）")
    @TableField("GXLX")
    private String gxlx;

    @ApiModelProperty(value = "共享条件")
    @TableField("GXTJ")
    private String gxtj;

    @ApiModelProperty(value = "是否敏感(Y/N)")
    @TableField("SFMG")
    private String sfmg;

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

    @ApiModelProperty(value = "不共享原因")
    @TableField("BGXYY")
    private String bgxyy;

    @ApiModelProperty(value = "数据敏感级别")
    @TableField("SJMGJB")
    private String sjmgjb;

    @ApiModelProperty(value = "来源系统")
    @TableField("LYXT")
    private String lyxt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getXxxbm() {
        return xxxbm;
    }

    public void setXxxbm(String xxxbm) {
        this.xxxbm = xxxbm;
    }
    public String getMlId() {
        return mlId;
    }

    public void setMlId(String mlId) {
        this.mlId = mlId;
    }
    public String getDmjId() {
        return dmjId;
    }

    public void setDmjId(String dmjId) {
        this.dmjId = dmjId;
    }
    public String getXxxzwm() {
        return xxxzwm;
    }

    public void setXxxzwm(String xxxzwm) {
        this.xxxzwm = xxxzwm;
    }
    public String getXxxywm() {
        return xxxywm;
    }

    public void setXxxywm(String xxxywm) {
        this.xxxywm = xxxywm;
    }
    public String getXxxms() {
        return xxxms;
    }

    public void setXxxms(String xxxms) {
        this.xxxms = xxxms;
    }
    public String getXxxlx() {
        return xxxlx;
    }

    public void setXxxlx(String xxxlx) {
        this.xxxlx = xxxlx;
    }
    public String getKflx() {
        return kflx;
    }

    public void setKflx(String kflx) {
        this.kflx = kflx;
    }
    public String getSfzj() {
        return sfzj;
    }

    public void setSfzj(String sfzj) {
        this.sfzj = sfzj;
    }
    public String getSfkk() {
        return sfkk;
    }

    public void setSfkk(String sfkk) {
        this.sfkk = sfkk;
    }
    public String getGxlx() {
        return gxlx;
    }

    public void setGxlx(String gxlx) {
        this.gxlx = gxlx;
    }
    public String getGxtj() {
        return gxtj;
    }

    public void setGxtj(String gxtj) {
        this.gxtj = gxtj;
    }
    public String getSfmg() {
        return sfmg;
    }

    public void setSfmg(String sfmg) {
        this.sfmg = sfmg;
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
    public String getBgxyy() {
        return bgxyy;
    }

    public void setBgxyy(String bgxyy) {
        this.bgxyy = bgxyy;
    }
    public String getSjmgjb() {
        return sjmgjb;
    }

    public void setSjmgjb(String sjmgjb) {
        this.sjmgjb = sjmgjb;
    }
    public String getLyxt() {
        return lyxt;
    }

    public void setLyxt(String lyxt) {
        this.lyxt = lyxt;
    }

    @Override
    public String toString() {
        return "WdMlxxx20230807{" +
            "id=" + id +
            ", xxxbm=" + xxxbm +
            ", mlId=" + mlId +
            ", dmjId=" + dmjId +
            ", xxxzwm=" + xxxzwm +
            ", xxxywm=" + xxxywm +
            ", xxxms=" + xxxms +
            ", xxxlx=" + xxxlx +
            ", kflx=" + kflx +
            ", sfzj=" + sfzj +
            ", sfkk=" + sfkk +
            ", gxlx=" + gxlx +
            ", gxtj=" + gxtj +
            ", sfmg=" + sfmg +
            ", sfsc=" + sfsc +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", bbh=" + bbh +
            ", bgxyy=" + bgxyy +
            ", sjmgjb=" + sjmgjb +
            ", lyxt=" + lyxt +
        "}";
    }
}
