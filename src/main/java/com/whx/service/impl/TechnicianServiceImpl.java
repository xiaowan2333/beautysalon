package com.whx.service.impl;

import com.whx.entity.Technician;
import com.whx.dao.TechnicianDao;
import com.whx.service.TechnicianService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Technician)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Service("technicianService")
public class TechnicianServiceImpl implements TechnicianService {
    @Resource
    private TechnicianDao technicianDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Technician queryById(Long id) {
        return this.technicianDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param technician 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Technician> queryByPage(Technician technician, PageRequest pageRequest) {
        long total = this.technicianDao.count(technician);
        return new PageImpl<>(this.technicianDao.queryAllByLimit(technician, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param technician 实例对象
     * @return 实例对象
     */
    @Override
    public Technician insert(Technician technician) {
        this.technicianDao.insert(technician);
        return technician;
    }

    /**
     * 修改数据
     *
     * @param technician 实例对象
     * @return 实例对象
     */
    @Override
    public Technician update(Technician technician) {
        this.technicianDao.update(technician);
        return this.queryById(technician.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.technicianDao.deleteById(id) > 0;
    }
}
