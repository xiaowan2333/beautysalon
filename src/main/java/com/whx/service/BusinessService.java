package com.whx.service;

import com.whx.entity.Business;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Business)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:50
 */
public interface BusinessService {

    /**
     * 据项目Id查询商家信息，项目信息，及配图
     * @param id
     * @return
     */
    ResponseData getBusInfoByProId(Long id);
}
