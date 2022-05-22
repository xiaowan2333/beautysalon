package com.whx.service.impl;

import com.whx.entity.Business;
import com.whx.dao.BusinessDao;
import com.whx.service.BusinessService;
import com.whx.util.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Business)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:50
 */
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
    @Resource
    private BusinessDao businessDao;

    /**
     * 据项目Id查询商家信息，项目信息，及配图
     * @param id
     * @return
     */
    @Override
    public ResponseData getBusInfoByProId(Long id) {
        try {
            Business busInfo = businessDao.getBusInfoByProId(id);
            return new ResponseData("0","请求成功！",busInfo);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseData("9999","网络异常");
        }
    }
}
