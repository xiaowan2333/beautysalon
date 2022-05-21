package com.whx.service;

import com.whx.entity.Sysuser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Sysuser)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
public interface SysuserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sysuser queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysuser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Sysuser> queryByPage(Sysuser sysuser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    Sysuser insert(Sysuser sysuser);

    /**
     * 修改数据
     *
     * @param sysuser 实例对象
     * @return 实例对象
     */
    Sysuser update(Sysuser sysuser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
