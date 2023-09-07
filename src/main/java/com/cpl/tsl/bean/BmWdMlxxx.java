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
@TableName("BM_WD_MLXXX")
@ApiModel(value="BmWdMlxxx对象", description="目录信息项")
public class BmWdMlxxx implements Serializable {

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

    @ApiModelProperty(value = "信息项长度")
    @TableField("XXXCD")
    private Integer xxxcd;

    @ApiModelProperty(value = "信息项最大长度")
    @TableField("XXXZDCD")
    private Integer xxxzdcd;

    @ApiModelProperty(value = "开放类型（01:有条件开放，02:无条件开放，03:完全不开放）")
    @TableField("KFLX")
    private String kflx;

    @ApiModelProperty(value = "开放条件")
    @TableField("KFTJ")
    private String kftj;

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

    @ApiModelProperty(value = "数据敏感级别(01:数据泄露后无危害；02:数据泄露后无危害，仅对特定公众和群体有益，且可能对其他公众和群体产生不利影响；03:数据泄露后会对个人、法人、其他组织或国家机关正常运作造成损害；04:数据泄漏后会对个人人身安全、法人正常运作或国家机关正常运作造成严重损害)")
    @TableField("SJMGJB")
    private String sjmgjb;

    @ApiModelProperty(value = "不共享原因")
    @TableField("BGXYY")
    private String bgxyy;

    @ApiModelProperty(value = "来源系统ID")
    @TableField("LYXT_ID")
    private String lyxtId;

    @ApiModelProperty(value = "系统所属分类")
    @TableField("XTSSFL")
    private String xtssfl;

    @ApiModelProperty(value = "数据区域范围")
    @TableField("SJQYFW")
    private String sjqyfw;

    @ApiModelProperty(value = "数据时间范围")
    @TableField("SJSJFWSTR")
    private String sjsjfwstr;

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
    public Integer getXxxcd() {
        return xxxcd;
    }

    public void setXxxcd(Integer xxxcd) {
        this.xxxcd = xxxcd;
    }
    public Integer getXxxzdcd() {
        return xxxzdcd;
    }

    public void setXxxzdcd(Integer xxxzdcd) {
        this.xxxzdcd = xxxzdcd;
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
    public String getSjmgjb() {
        return sjmgjb;
    }

    public void setSjmgjb(String sjmgjb) {
        this.sjmgjb = sjmgjb;
    }
    public String getBgxyy() {
        return bgxyy;
    }

    public void setBgxyy(String bgxyy) {
        this.bgxyy = bgxyy;
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
    public String getSjqyfw() {
        return sjqyfw;
    }

    public void setSjqyfw(String sjqyfw) {
        this.sjqyfw = sjqyfw;
    }
    public String getSjsjfwstr() {
        return sjsjfwstr;
    }

    public void setSjsjfwstr(String sjsjfwstr) {
        this.sjsjfwstr = sjsjfwstr;
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
        return "BmWdMlxxx{" +
            "id=" + id +
            ", xxxbm=" + xxxbm +
            ", mlId=" + mlId +
            ", dmjId=" + dmjId +
            ", xxxzwm=" + xxxzwm +
            ", xxxywm=" + xxxywm +
            ", xxxms=" + xxxms +
            ", xxxlx=" + xxxlx +
            ", xxxcd=" + xxxcd +
            ", xxxzdcd=" + xxxzdcd +
            ", kflx=" + kflx +
            ", kftj=" + kftj +
            ", sfzj=" + sfzj +
            ", sfkk=" + sfkk +
            ", gxlx=" + gxlx +
            ", gxtj=" + gxtj +
            ", sfmg=" + sfmg +
            ", sjmgjb=" + sjmgjb +
            ", bgxyy=" + bgxyy +
            ", lyxtId=" + lyxtId +
            ", xtssfl=" + xtssfl +
            ", sjqyfw=" + sjqyfw +
            ", sjsjfwstr=" + sjsjfwstr +
            ", sfsc=" + sfsc +
            ", cjrId=" + cjrId +
            ", cjsj=" + cjsj +
            ", xgrId=" + xgrId +
            ", xgsj=" + xgsj +
            ", bbh=" + bbh +
        "}";
    }
}
