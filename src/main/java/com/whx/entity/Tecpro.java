package com.whx.entity;

import java.io.Serializable;

/**
 * (Tecpro)实体类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
public class Tecpro implements Serializable {
    private static final long serialVersionUID = -57000492814709979L;
    
    private Long id;
    
    private Long tecid;
    
    private Long proid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTecid() {
        return tecid;
    }

    public void setTecid(Long tecid) {
        this.tecid = tecid;
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

}

