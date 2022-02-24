package com.cpl.tsl.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Ml{

    private static final long serialVersionUID = 1L;

    /**
     * 目录分类id
     */
    private String group_id;

    /**
     * 共享网站的目录id
     */
    private String cata_id;

    /**
     * 市（州）数据共享网站数据目录标识id（长度限制为32字符，各市（州）保持唯一）
     */
    private String cataid;

    /**
     * 共享网站目录名称
     */
    private String cata_title;

    /**
     * 信息资源目录编码
     */
    private String catacode;

    /**
     * 统一信用代码
     */
    private String credit_code;

    /**
     * 提供方内部部门
     */
    private String internalorgan;

    /**
     * 信息资源摘要
     */
    private String description;

    /**
     * 信息资源格式分类编码（见附录A.数据字典.信息资源格式分类）
     */
    private String resourceformat;

    /**
     * 信息资源格式类型编码（见附录A.数据字典.信息资源格式类型）
     */
    private String resourceformattype;

    /**
     * 其他类型资源格式描述
     */
    private String resourceformatother;

    /**
     * 当信息资源格式为电子表格和数据库类型时，数据项项列表信息必须填写，其他资源格式可以不上报，但若上报必须符合格式校验（详见Scheema定义
     */
    private List<CatalogcolumnSchema> columnlist;

    /**
     * 发布日期
     */
    private Date publishedtime;

    /**
     * 共享类型编码
     */
    private String shared_type;

    /**
     * 共享条件
     */
    private String shared_condition;

    /**
     * 共享方式类型编码（见附录A.数据字典.共享方式类型）
     */
    private String sharedway;

    /**
     * 开放类型
     */
    private Integer open_type;

    /**
     * 开放条件（对向社会开放资源的条件描述。如无条件，请填写无）
     */
    private Integer open_condition;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 更新周期（见附录A数据字典定义）
     */
    private Date update_cycle;

    /**
     * 目录状态（市（州）数据共享网站已发布的目录注册到共享网站为 “4”）
     */
    private Integer status;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getCataid() {
        return cataid;
    }

    public void setCataid(String cataid) {
        this.cataid = cataid;
    }

    public String getCata_title() {
        return cata_title;
    }

    public void setCata_title(String cata_title) {
        this.cata_title = cata_title;
    }

    public String getCatacode() {
        return catacode;
    }

    public void setCatacode(String catacode) {
        this.catacode = catacode;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }

    public String getInternalorgan() {
        return internalorgan;
    }

    public void setInternalorgan(String internalorgan) {
        this.internalorgan = internalorgan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceformat() {
        return resourceformat;
    }

    public void setResourceformat(String resourceformat) {
        this.resourceformat = resourceformat;
    }

    public String getResourceformattype() {
        return resourceformattype;
    }

    public void setResourceformattype(String resourceformattype) {
        this.resourceformattype = resourceformattype;
    }

    public String getResourceformatother() {
        return resourceformatother;
    }

    public void setResourceformatother(String resourceformatother) {
        this.resourceformatother = resourceformatother;
    }

    public List<CatalogcolumnSchema> getColumnlist() {
        return columnlist;
    }

    public void setColumnlist(List<CatalogcolumnSchema> columnlist) {
        this.columnlist = columnlist;
    }

    public Date getPublishedtime() {
        return publishedtime;
    }

    public void setPublishedtime(Date publishedtime) {
        this.publishedtime = publishedtime;
    }

    public String getShared_type() {
        return shared_type;
    }

    public void setShared_type(String shared_type) {
        this.shared_type = shared_type;
    }

    public String getShared_condition() {
        return shared_condition;
    }

    public void setShared_condition(String shared_condition) {
        this.shared_condition = shared_condition;
    }

    public String getSharedway() {
        return sharedway;
    }

    public void setSharedway(String sharedway) {
        this.sharedway = sharedway;
    }

    public Integer getOpen_type() {
        return open_type;
    }

    public void setOpen_type(Integer open_type) {
        this.open_type = open_type;
    }

    public Integer getOpen_condition() {
        return open_condition;
    }

    public void setOpen_condition(Integer open_condition) {
        this.open_condition = open_condition;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getUpdate_cycle() {
        return update_cycle;
    }

    public void setUpdate_cycle(Date update_cycle) {
        this.update_cycle = update_cycle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}