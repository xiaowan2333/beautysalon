package com.whx.controller;

import com.whx.entity.Image;
import com.whx.util.ResponseData;
import com.whx.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Image)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Api(tags = "图片请求接口")
@RestController
@RequestMapping("image")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;

    /**
     * 根据图片类型查询image
     * @param imagetype 图片类型
     * @return
     */
    @ApiOperation(value = "查询图片s",notes = "根据图片类型查询所有图片")
    @GetMapping("queryImageByType")
    public ResponseData queryImageByType(String imagetype){
        return imageService.queryImageByType(imagetype);
    }
}

