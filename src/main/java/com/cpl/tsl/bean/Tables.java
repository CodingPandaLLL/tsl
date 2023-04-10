package com.cpl.tsl.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

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
@TableName("TABLES")
@Data
@ApiModel(value = "Tables对象", description = "")
public class Tables implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("TABLE_CATALOG")
    private String tableCatalog;

    @TableField("TABLE_SCHEMA")
    private String tableSchema;

    @TableField("TABLE_NAME")
    private String tableName;

    @TableField("TABLE_TYPE")
    private String tableType;

    @TableField("ENGINE")
    private String engine;

    @TableField("VERSION")
    private Long version;

    @TableField("ROW_FORMAT")
    private String rowFormat;

    @TableField("TABLE_ROWS")
    private Long tableRows;

    @TableField("AVG_ROW_LENGTH")
    private Long avgRowLength;

    @TableField("DATA_LENGTH")
    private Long dataLength;

    @TableField("MAX_DATA_LENGTH")
    private Long maxDataLength;

    @TableField("INDEX_LENGTH")
    private Long indexLength;

    @TableField("DATA_FREE")
    private Long dataFree;

    @TableField("AUTO_INCREMENT")
    private Long autoIncrement;

//    @TableField("CREATE_TIME")
//    private LocalDateTime createTime;
//
//    @TableField("UPDATE_TIME")
//    private LocalDateTime updateTime;
//
//    @TableField("CHECK_TIME")
//    private LocalDateTime checkTime;

    @TableField("TABLE_COLLATION")
    private String tableCollation;

    @TableField("CHECKSUM")
    private Long checksum;

    @TableField("CREATE_OPTIONS")
    private String createOptions;

    @TableField("TABLE_COMMENT")
    private String tableComment;

    @Override
    public String toString() {
        return "Tables{" +
                "tableCatalog=" + tableCatalog +
                ", tableSchema=" + tableSchema +
                ", tableName=" + tableName +
                ", tableType=" + tableType +
                ", engine=" + engine +
                ", version=" + version +
                ", rowFormat=" + rowFormat +
                ", tableRows=" + tableRows +
                ", avgRowLength=" + avgRowLength +
                ", dataLength=" + dataLength +
                ", maxDataLength=" + maxDataLength +
                ", indexLength=" + indexLength +
                ", dataFree=" + dataFree +
                ", autoIncrement=" + autoIncrement +
//                ", createTime=" + createTime +
//                ", updateTime=" + updateTime +
//                ", checkTime=" + checkTime +
                ", tableCollation=" + tableCollation +
                ", checksum=" + checksum +
                ", createOptions=" + createOptions +
                ", tableComment=" + tableComment +
                "}";
    }
}
