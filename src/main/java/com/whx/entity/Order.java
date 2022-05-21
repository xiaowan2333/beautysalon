package com.whx.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -93530768499864360L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 关联user表的openId
     */
    private String openid;
    /**
     * 项目名称
     */
    private String proname;
    /**
     * 预约时间
     */
    private String makedate;
    /**
     * 预约客户姓名
     */
    private String username;
    /**
     * 预约状态
     */
    private String orderstate;
    /**
     * 下单时间
     */
    private String placedate;
    /**
     * 手机号
     */
    private String usertell;
    /**
     * 留言
     */
    private String information;
    /**
     * 关联商家id
     */
    private Long busid;
    /**
     * 关联产品id
     */
    private Long proid;
    
    private Long tecid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getMakedate() {
        return makedate;
    }

    public void setMakedate(String makedate) {
        this.makedate = makedate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public String getPlacedate() {
        return placedate;
    }

    public void setPlacedate(String placedate) {
        this.placedate = placedate;
    }

    public String getUsertell() {
        return usertell;
    }

    public void setUsertell(String usertell) {
        this.usertell = usertell;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getBusid() {
        return busid;
    }

    public void setBusid(Long busid) {
        this.busid = busid;
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    public Long getTecid() {
        return tecid;
    }

    public void setTecid(Long tecid) {
        this.tecid = tecid;
    }

}

