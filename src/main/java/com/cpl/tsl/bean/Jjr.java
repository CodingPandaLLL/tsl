package com.cpl.tsl.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 节假日
 * </p>
 *
 * @author lll
 * @since 2022-08-22
 */
@TableName("ss_jjr")
@ApiModel(value="Jjr对象", description="节假日")
public class Jjr implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("ID")
    private String id;

    @ApiModelProperty(value = "节假日名称")
    @TableField("JJRMC")
    private String jjrmc;

    @ApiModelProperty(value = "节假日期")
    @TableField("JJRQ")
    private LocalDate jjrq;

    @ApiModelProperty(value = "01元旦，02春节，03清明节，04劳动节，05端午节，06中秋节，07国庆节，08补班")
    @TableField("JJRLX")
    private String jjrlx;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getJjrmc() {
        return jjrmc;
    }

    public void setJjrmc(String jjrmc) {
        this.jjrmc = jjrmc;
    }
    public LocalDate getJjrq() {
        return jjrq;
    }

    public void setJjrq(LocalDate jjrq) {
        this.jjrq = jjrq;
    }
    public String getJjrlx() {
        return jjrlx;
    }

    public void setJjrlx(String jjrlx) {
        this.jjrlx = jjrlx;
    }

    @Override
    public String toString() {
        return "Jjr{" +
            "id=" + id +
            ", jjrmc=" + jjrmc +
            ", jjrq=" + jjrq +
            ", jjrlx=" + jjrlx +
        "}";
    }
}
