package com.cpl.tsl.bean;


import java.io.Serializable;

public class Jgdwzc  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 统计用区划代码（国家统计局网站2017年10月31发布）
     */
    private String region_code;

    /**
     * 统计用区划名字（国家统计局网站2017年10月31发布）
     */
    private String region_name;

    /**
     * 机构单位名称
     */
    private String dept_name;

    /**
     * 单位组织机构编码（请参照GB/T 31286-2014标准填写）
     */
    private String dept_code;

    /**
     * 统一信用代码
     */
    private String credit_code;

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getCredit_code() {
        return credit_code;
    }

    public void setCredit_code(String credit_code) {
        this.credit_code = credit_code;
    }
}