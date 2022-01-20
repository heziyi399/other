package com.hzyexample.other.service.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.hzyexample.other.entity.SkuImagesEntity;
import com.hzyexample.other.util.PageUtils;

import java.util.Map;

/**
 * sku图片
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

