package com.whx.service;

import com.whx.entity.Technician;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Technician)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
public interface TechnicianService {

    /**
     * 分页查询技师信息
     * @param page
     * @param limit
     * @return
     */
    ResponseData getTecInfos(int page, int limit);

    /**
     * 根据id查询技师信息
     * @param id
     * @return
     */
    ResponseData getTecInfoById(Long id);
}
