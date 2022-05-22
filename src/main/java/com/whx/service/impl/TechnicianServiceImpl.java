package com.whx.service.impl;

import com.whx.dao.ProjectDao;
import com.whx.entity.Project;
import com.whx.entity.Technician;
import com.whx.dao.TechnicianDao;
import com.whx.service.TechnicianService;
import com.whx.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ProjectDao projectDao;

    /**
     * 分页查询技师信息
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ResponseData getTecInfos(int page, int limit) {
        try{
            List<Technician> technicians = technicianDao.queryAllByLimit((page-1)*limit, limit);
            //获取总条数 返回给前端判断是否已经是最后一条数据。如果是则不在发送请求
            Long count = technicianDao.queryCount();
            return new ResponseData("0","请求成功！",technicians,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData("9999","网络异常！");
        }
    }

    /**
     * 根据技师id查询技师详细信息
     * @param id
     * @return
     */
    @Override
    public ResponseData getTecInfoById(Long id) {
        //分析：需要技师表信息以及对应的项目信息。因为是多对多关系 需要查询三张表 技师表 项目表 中间表
        //查询一个技师和对应的多个项目，用sql左外连接查出是多条数据，无法封装，必须分开查询
        try{
            Technician tecInfo = technicianDao.getTecInfoById(id);
            List<Project> projects = projectDao.getProByTec(id);
            System.out.println(projects);
            tecInfo.setProjects(projects);
            return new ResponseData("0","请求成功！",tecInfo);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData("9999","网络异常！");
        }
    }
}
