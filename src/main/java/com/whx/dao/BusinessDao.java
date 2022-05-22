package com.whx.dao;

import com.whx.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Business)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:44
 */
@Mapper
public interface BusinessDao {

    /**
     * 通过项目id查询商家信息
     * @param id
     * @return
     */
    Business getBusInfoByProId(Long id);
}

