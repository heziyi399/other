package com.hzyexample.other.service.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.hzyexample.other.entity.BrandEntity;
import com.hzyexample.other.util.PageUtils;

import java.util.Map;

/**
 * 品牌
 *
 * @author leifengyang
 * @email leifengyang@gmail.com
 * @date 2019-10-01 21:08:49
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);

}

