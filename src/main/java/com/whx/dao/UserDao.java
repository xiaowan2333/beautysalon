package com.whx.dao;

import com.whx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:55
 */
@Mapper
public interface UserDao {

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);


    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);



    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    User queryByUserName(String username);

    /**
     * 根据手机号 密码查询用户
     * @param phone
     * @param newPassword
     * @return
     */
    User queryByPhoneAndPwd(@Param("phone") String phone, @Param("password") String newPassword);

    /**
     * 根据token查询openid
     * @param token
     * @return
     */
    String queryOpenidByToken(String token);
}

