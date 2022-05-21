package com.whx.service;

import com.whx.entity.Business;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Business)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:50
 */
public interface BusinessService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Business queryById(Long id);

    /**
     * 分页查询
     *
     * @param business 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Business> queryByPage(Business business, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business insert(Business business);

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    Business update(Business business);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 据项目Id查询商家信息，项目信息，及配图
     * @param id
     * @return
     */
    ResponseData getBusInfoByProId(Long id);
}
