package com.whx.service;

import com.whx.entity.Image;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Image)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public interface ImageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Image queryById(Long id);

    /**
     * 根据图片类型查询图片
     * @param imagetype
     * @return
     */
    ResponseData queryImageByType(String imagetype);
}
