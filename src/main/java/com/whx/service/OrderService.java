package com.whx.service;

import com.whx.entity.Order;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Order)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
public interface OrderService {


    /**
     * 根据order信息和token创建订单
     * @param order
     * @param token
     * @return
     */
    ResponseData createOrder(Order order, String token);

    /**
     * 根据Order状态查询所有Order
     * @param orderstate
     * @param token
     * @return
     */
    ResponseData getOrderByState(String orderstate, String token);
}
