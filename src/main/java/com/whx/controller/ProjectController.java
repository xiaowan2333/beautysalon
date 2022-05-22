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

    /**
     * 分页查询
     *
     * @param project 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Project>> queryByPage(Project project, PageRequest pageRequest) {
        return ResponseEntity.ok(this.projectService.queryByPage(project, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Project> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.projectService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param project 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Project> add(Project project) {
        return ResponseEntity.ok(this.projectService.insert(project));
    }

    /**
     * 编辑数据
     *
     * @param project 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Project> edit(Project project) {
        return ResponseEntity.ok(this.projectService.update(project));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.projectService.deleteById(id));
    }

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

