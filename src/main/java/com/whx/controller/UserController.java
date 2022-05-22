package com.whx.controller;

import com.whx.entity.User;
import com.whx.service.UserService;
import com.whx.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Api(tags = "普通用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 注册用户
     * @param user
     * @return
     */
    @ApiOperation(value = "注册用户",notes = "根据前端传过来的信息注册用户")
    @PostMapping("userRegister")
    public ResponseData userRegister(User user){
        System.out.println("user"+user);
        return userService.userRegister(user);
    }

    @PostMapping("userLogin")
    public ResponseData userLogin(String phone,String password,String code){
        System.out.println("phone"+phone);
        System.out.println("password"+password);
        System.out.println("code"+code);//接收微信凭证
        return userService.userLogin(phone,password,code);
    }
}

