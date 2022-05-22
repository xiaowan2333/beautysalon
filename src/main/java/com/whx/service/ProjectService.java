package com.whx.service;

import com.whx.entity.Project;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Project)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public interface ProjectService {

    /**
     * 获取所有项目信息
     * @return
     * @param page
     * @param limit
     */
    ResponseData getProinfos(int page, int limit);

    /**
     * 根据id获取所有项目信息
     * @return
     * @param id
     */
    ResponseData getProInfoById(Long id);
}
