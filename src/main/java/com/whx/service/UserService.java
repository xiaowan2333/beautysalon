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
