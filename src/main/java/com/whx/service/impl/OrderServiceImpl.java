package com.whx.service.impl;

import com.whx.dao.UserDao;
import com.whx.entity.Order;
import com.whx.dao.OrderDao;
import com.whx.service.OrderService;
import com.whx.util.ResponseData;
import com.whx.util.StringUtil;
import com.whx.vo.OrderVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private UserDao userDao;
    /**
     * 创建一个订单
     * @param order
     * @param token
     * @return
     */
    @Override
    public ResponseData createOrder(Order order, String token) {
        String username = order.getUsername();
        String usertell = order.getUsertell();
        //判断是否有用户信息（这个是前端form中写进来的，前端没判断，可能为空）
        //没有判断留言，就是留言可以为空
        if(StringUtil.isNull(username)||StringUtil.isNull(usertell)){
            return new ResponseData("9003","参数为空");
        }
        try {
            //1.定义dao层 根据token获取到openid
            String openid = userDao.queryOpenidByToken(token);
            //2.获取系统当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            order.setOpenid(openid);
            order.setPlacedate(sdf.format(new Date()));
            order.setOrderstate("0");//状态默认为0
            //3.生成订单
            orderDao.insert(order);
            return new ResponseData("0","请求成功");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999","网络异常");
        }

    }

    /**
     * 根据Order状态和token，查询所有Order
     * @param orderstate
     * @param token
     * @return
     */
    @Override
    public ResponseData getOrderByState(String orderstate, String token) {
        try {
            //如上根据token获取openid
            String openid = userDao.queryOpenidByToken(token);

            Order order = new Order();
            order.setOpenid(openid);
            order.setOrderstate(orderstate);
            List<OrderVo> orders = orderDao.queryOrders(order);
            return new ResponseData("0","请求成功!",orders);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999","网络异常!");
        }
    }
}
