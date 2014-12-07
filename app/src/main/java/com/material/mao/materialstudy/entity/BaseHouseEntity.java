package com.material.mao.materialstudy.entity;

/**
 * Created by Administrator on 2014/12/7.
 */
public class BaseHouseEntity {
    private String name;
    private String desc;
    private String headImageUrl;

    public BaseHouseEntity(String name){
        this.name = name;
    }

    public BaseHouseEntity(String name, String desc, String headImageUrl) {
        this.name = name;
        this.desc = desc;
        this.headImageUrl = headImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }
}
