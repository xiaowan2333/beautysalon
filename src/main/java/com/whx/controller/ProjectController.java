package com.whx.controller;

import com.whx.entity.Project;
import com.whx.util.ResponseData;
import com.whx.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Project)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Api(tags = "项目接口")
@RestController
@RequestMapping("project")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private ProjectService projectService;


    @ApiOperation(value = "获取项目信息",notes = "获取所有的项目信息")
    @GetMapping("getProinfos")
    public ResponseData getProinfos(int page,int limit){
        return projectService.getProinfos(page,limit);
    }

    /**
     * 根据id获取项目信息
     * @param id
     * @return
     */
    @ApiOperation(value = "获取项目信息",notes = "根据id获取项目信息")
    @GetMapping("getProInfoById")
    public ResponseData getProInfoById(Long id){
        return projectService.getProInfoById(id);
    }
}

