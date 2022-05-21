package com.whx.entity;

import java.io.Serializable;

/**
 * (Technician)实体类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
public class Technician implements Serializable {
    private static final long serialVersionUID = 450900017159290317L;
    /**
     * 技师id
     */
    private Long id;
    /**
     * 技师简介
     */
    private String techexplain;
    /**
     * 技师姓名
     */
    private String techname;
    /**
     * 关联商家id
     */
    private Long busid;
    /**
     * 技师头像路径
     */
    private String imageurl;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechexplain() {
        return techexplain;
    }

    public void setTechexplain(String techexplain) {
        this.techexplain = techexplain;
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}

