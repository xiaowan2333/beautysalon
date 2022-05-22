package com.whx.controller;

import com.whx.entity.Business;
import com.whx.service.BusinessService;
import com.whx.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Business)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:44
 */
@Api(tags = "商家模块接口")
@RestController
@RequestMapping("business")
public class BusinessController {
    /**
     * 服务对象
     */
    @Resource
    private BusinessService businessService;


    /**
     * 根据项目Id查询商家信息，项目信息，及配图
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询商家",notes = "查询商家名字，商家服务时间，项目名，图片")
    @GetMapping("getBusInfoByProId")
    public ResponseData getBusInfoByProId(Long id){
        return businessService.getBusInfoByProId(id);
    }
}

