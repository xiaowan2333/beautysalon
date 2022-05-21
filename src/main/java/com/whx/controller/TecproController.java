package com.whx.controller;

import com.whx.entity.Tecpro;
import com.whx.service.TecproService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Tecpro)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Api(tags ="技师-项目连接表")
@RestController
@RequestMapping("tecpro")
public class TecproController {
    /**
     * 服务对象
     */
    @Resource
    private TecproService tecproService;

    /**
     * 分页查询
     *
     * @param tecpro 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Tecpro>> queryByPage(Tecpro tecpro, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tecproService.queryByPage(tecpro, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Tecpro> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tecproService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tecpro 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Tecpro> add(Tecpro tecpro) {
        return ResponseEntity.ok(this.tecproService.insert(tecpro));
    }

    /**
     * 编辑数据
     *
     * @param tecpro 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Tecpro> edit(Tecpro tecpro) {
        return ResponseEntity.ok(this.tecproService.update(tecpro));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tecproService.deleteById(id));
    }

}

