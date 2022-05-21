package com.whx.controller;

import com.whx.entity.Technician;
import com.whx.service.TechnicianService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Technician)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Api(tags = "技师接口")
@RestController
@RequestMapping("technician")
public class TechnicianController {
    /**
     * 服务对象
     */
    @Resource
    private TechnicianService technicianService;

    /**
     * 分页查询
     *
     * @param technician 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Technician>> queryByPage(Technician technician, PageRequest pageRequest) {
        return ResponseEntity.ok(this.technicianService.queryByPage(technician, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Technician> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.technicianService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param technician 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Technician> add(Technician technician) {
        return ResponseEntity.ok(this.technicianService.insert(technician));
    }

    /**
     * 编辑数据
     *
     * @param technician 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Technician> edit(Technician technician) {
        return ResponseEntity.ok(this.technicianService.update(technician));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.technicianService.deleteById(id));
    }

}

