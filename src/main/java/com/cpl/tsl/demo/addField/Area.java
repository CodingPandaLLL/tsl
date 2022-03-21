package com.cpl.tsl.demo.addField;

/**
 * @Date 2022/3/8 17:29
 * @Version 1.0
 */
public enum Area {
    CD("028", "成都"),
    BJ("010", "北京");
    private String name;
    private String code;

    Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 根据code获取城市名称
     * @param code
     * @return
     */
    public static String getNameByCode(String code){
        for (Area area:Area.values()
        ) {
            if (area.code.equals(code))
                return area.name;
        }
        return null;
    }
}


