package com.whx.dao;

import com.whx.entity.Technician;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Technician)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Mapper
public interface TechnicianDao {

    /**
     * 查询指定行数据
     *
     * @param offset 查询条件
     * @param limit  分页对象
     * @return 对象列表
     */
    List<Technician> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询技师条数
     * @return
     */
    Long queryCount();

    /**
     * 根据技师id获取技师所有信息
     * @param id
     * @return
     */
    Technician getTecInfoById(Long id);
}

