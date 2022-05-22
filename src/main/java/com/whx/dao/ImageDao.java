package com.whx.dao;

import com.whx.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Image)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Mapper
public interface ImageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Image queryById(Long id);

    /**
     *
     * @param imagetype
     * @return
     */
    List<Image> queryImageByType(String imagetype);
}

