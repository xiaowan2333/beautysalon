package com.whx.entity;

import java.io.Serializable;

/**
 * (Projecttype)实体类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public class Projecttype implements Serializable {
    private static final long serialVersionUID = 303467670599707597L;
    /**
     * 项目类型id
     */
    private Long id;
    /**
     * 项目类型
     */
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

