package com.whx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.whx.entity.User;
import com.whx.dao.UserDao;
import com.whx.service.UserService;
import com.whx.util.HttpClientUtil;
import com.whx.util.ResponseData;
import com.whx.util.StringUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public ResponseData userRegister(User user) {
        String phone = user.getPhone();
        String username = user.getUsername();
        String password = user.getPassword();
        //非空校验
        if (StringUtil.isNull(phone)) {
            return new ResponseData("9901", "手机号为空");
        }
        if (StringUtil.isNull(password)) {
            return new ResponseData("9902", "密码为空");
        }
        if (StringUtil.isNull(username)) {
            return new ResponseData("9903", "用户名为空");
        }
        try {
            User queryUser = userDao.queryByUserName(username);
            if (queryUser != null) {
                return new ResponseData("9904", "用户名已经存在");
            }
            //加密
            Md5Hash md5Hash = new Md5Hash(password, "Chauvin", 10);
            String newPassword = md5Hash.toString();//加密后的密码
            //保存
            user.setPassword(newPassword);
            //调用dao层进行持久化
            userDao.insert(user);
            return new ResponseData("0", "请求成功");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999", "网络异常");
        }
    }

    @Override
    public ResponseData userLogin(String phone, String password, String code) {
        //非空验证
        if (StringUtil.isNull(phone)) {
            return new ResponseData("9901", "手机号为空");
        }
        if (StringUtil.isNull(password)) {
            return new ResponseData("9902", "密码为空");
        }
        //密码加密
        Md5Hash md5Hash = new Md5Hash(password, "Chauvin", 10);
        String newPassword = md5Hash.toString();
        //查询
        System.out.println(phone);
        System.out.println("new password:::"+newPassword);
        User user = userDao.queryByPhoneAndPwd(phone, newPassword);
        if (user == null) {
            return new ResponseData("9005","账号密码不匹配");
        }
        try{
            //4.调用微信的接口 请求方式 get 模拟一个get请求
//https://api.weixin.qq.com/sns/jscode2session？appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxd0759f7e1d44dbfa&secret=840f22d4f6fcf979a5715eea850fb4a7&js_code="+code+"&grant_type=authorization_code";
            String result = HttpClientUtil.doGet(url);//返回一个包含session_key和openid
            System.out.println("result = "+result);

            //5.获取session_key 和 openid 字符串 转 json
            JSONObject jsonResult = (JSONObject)JSONObject.parse(result);
            String session_key = (String)jsonResult.get("session_key");
            String openid = (String)jsonResult.get("openid");
            System.out.println("session_key = "+session_key);
            System.out.println("openid = "+openid);

            //6.生成自定义登录状态
            Md5Hash md5Hash1 = new Md5Hash(session_key,openid,10);
            String token = md5Hash1.toString();

            //7.保存(跟新) user token、session_key openid 根据 id去跟新
            user.setOpenid(openid);
            user.setSessionkey(session_key);
            user.setToken(token);
            userDao.update(user);
            System.out.println(token);
            return new ResponseData("0","请求成功",token);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData("9999","网络异常");
        }
    }
}
