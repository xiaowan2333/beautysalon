package com.whx.controller;

import com.whx.entity.Technician;
import com.whx.service.TechnicianService;
import com.whx.util.ResponseData;
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

    @GetMapping("getTecInfos")
    public ResponseData getTecInfos(int page, int limit){
        System.out.println("page = "+page);
        System.out.println("limit = "+limit);
        return technicianService.getTecInfos(page,limit);
    }

    @GetMapping("getTecInfoById")
    public ResponseData getTecInfoById(Long id){
        System.out.println("Id = "+id);
        return technicianService.getTecInfoById(id);
    }
}

