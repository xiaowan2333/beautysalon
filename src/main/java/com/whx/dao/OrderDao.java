package com.whx.dao;

import com.whx.entity.Order;
import com.whx.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Mapper
public interface OrderDao {

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int insert(Order order);

    /**
     * 全查询
     * 根据Order查找相同属性的所有Order
     * @param order
     * @return
     */
    List<OrderVo> queryOrders(Order order);

}

