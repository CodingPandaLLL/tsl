package com.cpl.tsl.bean;

import com.cpl.tsl.annotation.DataDict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "Poetry", description = "Poetry实体类")
@Data
public class Poetry implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "来源")
    private String origin;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "时间")
    private String createTime;

    @ApiModelProperty(value = "备注")
    private String bak;

    @ApiModelProperty(value = "备注")
    private String bak1;
}
