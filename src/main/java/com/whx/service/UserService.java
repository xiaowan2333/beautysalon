package com.whx.service;

import com.whx.entity.User;
import com.whx.util.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (User)表服务接口
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResponseData userRegister(User user);

    /**
     * 用户登录
     * @param phone
     * @param password
     * @param code
     * @return
     */
    ResponseData userLogin(String phone, String password, String code);

}
