package com.whx.dao;

import com.whx.entity.Sysuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Sysuser)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Mapper
public interface SysuserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysuser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param sysuser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Sysuser> queryAllByLimit(Sysuser sysuser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param sysuser 查询条件
     * @return 总行数
     */
    long count(Sysuser sysuser);

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 影响行数
     */
    int insert(Sysuser sysuser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sysuser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Sysuser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Sysuser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Sysuser> entities);

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 影响行数
     */
    int update(Sysuser sysuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

