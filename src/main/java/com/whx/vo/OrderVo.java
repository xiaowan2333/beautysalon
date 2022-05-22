package com.whx.vo;

import com.whx.entity.Image;

/**
 * @Author: XiaoWan
 * @Date: 2022/5/21 22:50
 */
public class OrderVo {

    /**
     * 项目名称
     */
    private String proname;
    /**
     * 项目价格
     */
    //????
    private Double proprice;
    /**
     * 图片路径
     */
    private String imageurl;
    /**
     * 商家名称
     */
    private String busname;
    /**
     * 服务时间
     */
    private String servertime;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public Double getProprice() {
        return proprice;
    }

    public void setProprice(Double proprice) {
        this.proprice = proprice;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }
}
