package com.whx.dao;

import com.whx.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Project)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Mapper
public interface ProjectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Project queryById(Long id);

    /**
     * 查询所有项目信息
     * @return
     * @param page
     * @param limit
     */
    List<Project> getProinfos(@Param("page") int page,@Param("limit") int limit);

    /**
     * 获取项目总条数
     * @return
     */
    Long queryCount();

}

