package com.whx.service;

import com.whx.entity.Projecttype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Projecttype)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public interface ProjecttypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Projecttype queryById(Long id);

    /**
     * 分页查询
     *
     * @param projecttype 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Projecttype> queryByPage(Projecttype projecttype, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param projecttype 实例对象
     * @return 实例对象
     */
    Projecttype insert(Projecttype projecttype);

    /**
     * 修改数据
     *
     * @param projecttype 实例对象
     * @return 实例对象
     */
    Projecttype update(Projecttype projecttype);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
