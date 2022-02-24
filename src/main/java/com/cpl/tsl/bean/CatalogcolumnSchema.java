package com.cpl.tsl.bean;

import java.io.Serializable;
import java.util.Date;

public class CatalogcolumnSchema {

    /**
     * 信息项编码
     */
    private String columnid;

    /**
     * 信息项名称
     */
    private String namecn;

    /**
     * 数据类型编码（见附录A.数据字典.数据类型）
     */
    private String dataformat;

    /**
     * 数据长度
     */
    private Integer length;

    /**
     * 排序编号
     */
    private Integer order_id;

    /**
     * 更新时间
     */
    private Date updatetime;

    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    public String getNamecn() {
        return namecn;
    }

    public void setNamecn(String namecn) {
        this.namecn = namecn;
    }

    public String getDataformat() {
        return dataformat;
    }

    public void setDataformat(String dataformat) {
        this.dataformat = dataformat;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
