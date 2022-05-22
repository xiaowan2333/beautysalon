package com.whx.controller;

import com.whx.entity.Order;
import com.whx.service.OrderService;
import com.whx.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Api(tags = "菜单接口")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;


    @ApiOperation(value = "创建订单",notes = "用前端拿来的数据创建订单")
    @PostMapping("createOrder")
    public ResponseData createOrder(Order order,String token){
        System.out.println("token = "+token);
        System.out.println("order = "+order);
        return orderService.createOrder(order,token);
    }

    @ApiOperation(value = "查询订单",notes = "根据订单状态查询")
    @GetMapping("getOrderByState")
    public ResponseData getOrderByState(String orderstate,String token){
        return orderService.getOrderByState(orderstate,token);
    }
}

