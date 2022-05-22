package com.whx.service.impl;

import com.whx.entity.Image;
import com.whx.dao.ImageDao;
import com.whx.util.ResponseData;
import com.whx.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author XiaoWan
 * @since 2022-05-14 11:39:54
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Image queryById(Long id) {
        return this.imageDao.queryById(id);
    }

    /**
     * 根据图片类型查询图片
     * @param imagetype
     * @return
     */
    @Override
    public ResponseData queryImageByType(String imagetype) {
        try {
            List<Image> images = imageDao.queryImageByType(imagetype);
            return new ResponseData("0","请求成功！",images);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData("9999","网络异常！");
        }
    }
}
