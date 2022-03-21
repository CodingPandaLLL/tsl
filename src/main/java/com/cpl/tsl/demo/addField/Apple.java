package com.cpl.tsl.demo.addField;


import com.cpl.tsl.annotation.DataDict;

import java.math.BigDecimal;
public class Apple{
    private Integer id;
    private String name;
    private BigDecimal money;
    @DataDict(type = "1212")
    private Integer num;
    @TextDisplay(AreaValueProvider.class)
    private String area;//产地
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Apple(Integer id, String name, BigDecimal money, Integer num, String area) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                ", area='" + area + '\'' +
                '}';
    }
}




