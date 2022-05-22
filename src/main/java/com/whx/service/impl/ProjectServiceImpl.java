package com.whx.service.impl;

import com.whx.entity.Project;
import com.whx.dao.ProjectDao;
import com.whx.util.ResponseData;
import com.whx.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Project)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectDao projectDao;

    /**
     * 查询所有项目信息
     * @return
     * @param page
     * @param limit
     */
    @Override
    public ResponseData getProinfos(int page, int limit) {
        try {
            List<Project> projects = projectDao.getProinfos((page-1)*limit,limit);
            Long count = projectDao.queryCount();
            return new ResponseData("0","请求成功！",projects,count);
//            return new ResponseData("9999","网络异常");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999","网络异常");
        }
    }

    /**
     * 根据id查询项目信息
     * @return
     * @param id
     */
    @Override
    public ResponseData getProInfoById(Long id) {
        try {
            Project project = projectDao.queryById(id);
            return new ResponseData("0","请求成功！",project);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999","网络异常！");
        }
    }
}
