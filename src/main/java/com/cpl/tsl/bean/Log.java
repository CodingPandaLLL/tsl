package com.cpl.tsl.bean;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author lll
 * @since 2023-04-10
 */
@ApiModel(value="Log对象", description="")
@Data
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "行为描述")
    private String action;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建者id")
    private String creatorId;

    @ApiModelProperty(value = "模块")
    private String module;

    @ApiModelProperty(value = "标识")
    private String flag;

    @Override
    public String toString() {
        return "Log{" +
            "id=" + id +
            ", action=" + action +
            ", createTime=" + createTime +
            ", creator=" + creator +
            ", creatorId=" + creatorId +
            ", module=" + module +
            ", flag=" + flag +
        "}";
    }
}
